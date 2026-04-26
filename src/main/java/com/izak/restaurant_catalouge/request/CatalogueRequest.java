package com.izak.restaurant_catalouge.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueRequest {
    private Long id;

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String description;

    private boolean isVeg = false;
    private double price=0.0;
    private Integer restaurantId;
    private Integer quantity = 0;
}
