package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.Detail;
import co.edu.unbosque.ElectroShop.service.DetailsService;
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
@RequestMapping("/details")
@CrossOrigin(origins = "*")
@Transactional

public class DetailController {

    @Autowired
    private DetailsService detailService;

    @PostMapping("api/details/faker/{amount}")
    @Operation(summary = "Create fake details", description = "Generates a specified number of fake details using Faker library and saves them to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Details created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Detail.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> createFakeDetails(
            @Parameter(description = "The number of fake details to generate") @PathVariable int amount) {
        List<Detail> details = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Detail detail = new Detail(
                    FakerInstance.getFakerEsp().random().nextInt(0, 100)
            );
            details.add(detail);
        }
        if (detailService.saveAll(details)) {
            return new ResponseEntity<>(details, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
