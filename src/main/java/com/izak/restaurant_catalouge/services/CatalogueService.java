package com.izak.restaurant_catalouge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.izak.restaurant_catalouge.DTOs.CatalogueDTO;
import com.izak.restaurant_catalouge.DTOs.CataloguePage;
import com.izak.restaurant_catalouge.DTOs.RestaurantDTO;
import com.izak.restaurant_catalouge.entities.CatalogueEntity;
import com.izak.restaurant_catalouge.mappers.CatalogueMappers;
import com.izak.restaurant_catalouge.repositories.CatalogueRepo;
import com.izak.restaurant_catalouge.request.CatalogueRequest;

import lombok.Data;

@Service
@Data
public class CatalogueService {

    private static final String RESTAURANT_SERVICE_URL = "%s/api/v1/restaurants/fetch/%d";   
    
    @Value("${restaurant.restaurant_listing.url}")
    private String URL;
    private final CatalogueRepo catalogueRepo;
    private final RestTemplate restTemplate;

    public CatalogueService(CatalogueRepo catalogueRepo, RestTemplate restTemplate) {
        this.catalogueRepo = catalogueRepo;
        this.restTemplate = restTemplate;
    }

    public CatalogueDTO addItem(CatalogueRequest catalogueRequest) {
        
        CatalogueEntity savedCatalogue = catalogueRepo.save(
            CatalogueMappers.INSTANCE.toCatalogueEntity(catalogueRequest)
        );
        return CatalogueMappers.INSTANCE.toCatalogueDTO(savedCatalogue);
    }

    public CataloguePage fetchItem(Long id) {

        List<CatalogueEntity> items = fetchCatalogueItem(id);
        RestaurantDTO restaurant = fetchRstaurantFromEurekaMS(id);
        return new CataloguePage(items, restaurant);
    }

    private RestaurantDTO fetchRstaurantFromEurekaMS(Long id) {
        String url = String.format(RESTAURANT_SERVICE_URL, URL, id);
        return restTemplate.getForObject(url, RestaurantDTO.class);
        
    }

    private List<CatalogueEntity> fetchCatalogueItem(Long id) {
        return catalogueRepo.findByRstaurantId(id);
    }


}
