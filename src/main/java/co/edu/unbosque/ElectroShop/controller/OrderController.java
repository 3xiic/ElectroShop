package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.*;
import co.edu.unbosque.ElectroShop.service.ClientService;
import co.edu.unbosque.ElectroShop.service.DetailService;
import co.edu.unbosque.ElectroShop.service.OrderService;
import co.edu.unbosque.ElectroShop.service.ProductService;
import co.edu.unbosque.ElectroShop.utils.CardPass;
import co.edu.unbosque.ElectroShop.utils.PaySimu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
@Transactional

public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DetailService detailService;

    @Autowired
    private ProductService productService;


    @Operation(summary = "Procesa una orden de compra con una tarjeta de credito/debito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La orden se ha procesado correctamente",
                    content = {@Content( schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "La orden no se ha podido procesar",
                    content = {@Content( schema = @Schema(implementation = String.class)) })
    })
    @PostMapping("/process")
    public ResponseEntity<Object> processOrder(
            @Parameter(description = "Id del cliente que esta realizando la orden")
            @RequestParam long id_client,
            @Parameter(description = "Id del detalle que se esta ordenando")
            @RequestParam long id_detail,
            @Parameter(description = "Numero de la tarjeta de credito para realizar el pago")
            @RequestParam int card_number,
            @Parameter(description = "Monto total de la orden")
            @RequestParam int mount) {
        DetailDTO detail = detailService.getDetails(id_detail);
        ClientDTO client = clientService.getClient(id_client);
        if(client == null || detail == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no se ha podido procesar, porque el cliente o el detalle no existen");
        ProductDTO product = productService.getProduct(detail.getProduct().getProduct_id());
        if (product.getStock() < detailService.getDetails(id_detail).getAmount())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no se ha podido , porque el stock es insuficiente");
        OrderDTO order = orderService.getOrder(detail.getOrder().getOrder_id());
        if (order.isPaid())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no se ha podido procesar, porque ya se ha procesado");
        if(order.getTotal_pay() > mount)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no se ha podido procesar, porque el monto es insuficiente");
        if (!CardPass.isValidCard(card_number))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no se ha podido procesar, porque la tarjeta no es valida");
        PaySimu.simulatePayment();
        product.setStock(product.getStock() - detailService.getDetails(id_detail).getAmount());
        productService.saveProduct(product);
        order.setPaid(true);
        orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body("Orden Procesada");
    }



	
}
