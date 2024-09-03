package co.edu.unbosque.ElectroShop.controller;

import co.edu.unbosque.ElectroShop.model.Category;
import co.edu.unbosque.ElectroShop.service.CategoryService;
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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("api/categories/faker/{amount}")
    @Operation(summary = "Create fake categories", description = "Generates a specified number of fake categories using Faker library and saves them to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categories created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> createFakeCategories(
            @Parameter(description = "The number of fake categories to generate") @PathVariable int amount) {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Category category = new Category(
                    FakerInstance.getFakerEsp().commerce().department(),
                    FakerInstance.getFakerEsp().lorem().paragraph()
            );
            categories.add(category);
        }

        if (categoryService.saveAll(categories)) {
            return new ResponseEntity<>(categories, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
