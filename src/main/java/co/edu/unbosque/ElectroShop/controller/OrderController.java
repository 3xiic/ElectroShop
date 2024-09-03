package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.Order;
import co.edu.unbosque.ElectroShop.service.OrderService;
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

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
@Transactional

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("api/orders/faker/{amount}")
    @Operation(summary = "Create fake orders", description = "Generates a specified number of fake orders using Faker library and saves them to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Orders created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> createFakeOrders(
            @Parameter(description = "The number of fake orders to generate") @PathVariable int amount) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Order order = new Order(
                    FakerInstance.getFakerEsp().number().numberBetween(0, 1000),
                    FakerInstance.getFakerEsp().date().past(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()            );
            orders.add(order);
        }
        if (orderService.saveAll(orders)) {
            return new ResponseEntity<>(orders, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

	
}
