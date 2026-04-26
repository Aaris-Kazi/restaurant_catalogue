package com.izak.restaurant_catalouge.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.izak.restaurant_catalouge.DTOs.CatalogueDTO;
import com.izak.restaurant_catalouge.DTOs.CataloguePage;
import com.izak.restaurant_catalouge.request.CatalogueRequest;
import com.izak.restaurant_catalouge.services.CatalogueService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/catalogue")
public class CatalogueController {
    private final CatalogueService catalogueService;
    // private final RestTemplate restTemplate;

    public CatalogueController(CatalogueService catalogueServices, RestTemplate restTemplate) {
        this.catalogueService = catalogueServices;
        // catalogueServices.setRestTemplate(restTemplate);

        // this.restTemplate = restTemplate;
    }

    @PostMapping("/addItem")
    public ResponseEntity<CatalogueDTO> addItem(@RequestBody @Valid CatalogueRequest catalogueRequest) {
        CatalogueDTO createdItem = catalogueService.addItem(catalogueRequest);
        
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/fetchItems/{id}")
    public ResponseEntity<CataloguePage> fetchItem(@PathVariable Long id) {
        CataloguePage item = catalogueService.fetchItem(id);
        return ResponseEntity.ok(item);
    }
}
