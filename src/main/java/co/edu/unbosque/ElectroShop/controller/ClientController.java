package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.Client;
import co.edu.unbosque.ElectroShop.service.ClientService;
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
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
@Transactional

public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("api/clients/faker/{amount}")
    @Operation(summary = "Create fake clients", description = "Generates a specified number of fake clients using Faker library and saves them to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Clients created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> createFakeClients(
            @Parameter(description = "The number of fake clients to generate") @PathVariable int amount) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Client client = new Client(
                    FakerInstance.getFakerEsp().name().firstName(),
                    FakerInstance.getFakerEsp().name().lastName(),
                    FakerInstance.getFakerEsp().address().streetAddress(),
                    FakerInstance.getFakerEsp().phoneNumber().phoneNumber()
            );
            clients.add(client);
        }
        if (clientService.saveAll(clients)) {
            return new ResponseEntity<>(clients, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
