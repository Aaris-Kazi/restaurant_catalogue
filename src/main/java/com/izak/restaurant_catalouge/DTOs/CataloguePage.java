package com.izak.restaurant_catalouge.DTOs;

import java.util.List;

import com.izak.restaurant_catalouge.entities.CatalogueEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CataloguePage {
    
    private List<CatalogueEntity> catalogueEntities;
    private RestaurantDTO restaurants;
}
