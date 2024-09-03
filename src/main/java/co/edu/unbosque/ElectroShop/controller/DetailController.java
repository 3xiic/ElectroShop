package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.Detail;
import co.edu.unbosque.ElectroShop.model.Order;
import co.edu.unbosque.ElectroShop.model.Product;
import co.edu.unbosque.ElectroShop.model.ProductDTO;
import co.edu.unbosque.ElectroShop.service.DetailsService;
import co.edu.unbosque.ElectroShop.service.OrderService;
import co.edu.unbosque.ElectroShop.service.ProductService;
import co.edu.unbosque.ElectroShop.util.FakerInstance;
import com.github.javafaker.Faker;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*")
@Transactional

public class DetailController {

    @Autowired
    private DetailsService detailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("api/details/faker/{amount}")
    @Operation(summary = "Create fake details", description = "Generates a specified number of fake details using Faker library and saves them to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Details created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Detail.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "No orders found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "No products found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> createFakeDetails(
            @Parameter(description = "The number of fake details to generate") @PathVariable int amount) {
        List<Detail> details = new ArrayList<>();
        List<Order> orders = orderService.getAllOrders();
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>("No products found", HttpStatus.NOT_FOUND);
        }
        if (orders.isEmpty()) {
            return new ResponseEntity<>("No orders found", HttpStatus.NOT_FOUND);
        }
        int productSize = products.size() - 1;
        int orderSize = orders.size() - 1;
        for (int i = 0; i < amount; i++) {
            Detail detail = new Detail(
                    FakerInstance.getFakerEsp().random().nextInt(0, 100)
            );
            detail.setOrder(orders.get(FakerInstance.getFakerEsp().random().nextInt(0, orderSize)));
            detail.setProduct(products.get(FakerInstance.getFakerEsp().random().nextInt(0, productSize)));
            details.add(detail);
        }
        if (detailService.saveAll(details)) {
            return new ResponseEntity<>(details, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
