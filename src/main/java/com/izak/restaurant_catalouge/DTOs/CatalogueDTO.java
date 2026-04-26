package com.izak.restaurant_catalouge.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueDTO {
    private Long id;
    private String name;
    private String description;
    private boolean isVeg;
    private double price;
    private Long restaurantId;
    private Integer quantity = 0;
}
