package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.Product;
import co.edu.unbosque.ElectroShop.service.ProductService;
import co.edu.unbosque.ElectroShop.util.FakerInstance;
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

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
@Transactional

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("api/products/faker/{amount}")
    @Operation(summary = "Create fake products", description = "Generates a specified number of fake products using Faker library and saves them to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Products created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> createFakeProducts(@Parameter(description = "The number of fake products to generate") @PathVariable int amount) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Product product = new Product(
                    FakerInstance.getFakerEsp().commerce().productName(),
                    Double.parseDouble(FakerInstance.getFakerEsp().commerce().price().replace(",", ".")),
                    FakerInstance.getFakerEsp().random().nextInt(0, 100)
            );
            products.add(product);
        }
        if (productService.saveAll(products)) {
            return new ResponseEntity<>(products, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
