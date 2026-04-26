package com.izak.restaurant_catalouge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.izak.restaurant_catalouge.DTOs.CatalogueDTO;
import com.izak.restaurant_catalouge.entities.CatalogueEntity;
import com.izak.restaurant_catalouge.request.CatalogueRequest;

@Mapper
public interface CatalogueMappers {
    
    CatalogueMappers INSTANCE = Mappers.getMapper(CatalogueMappers.class);

    CatalogueEntity toCatalogueEntity(CatalogueDTO catalogueDTO);
    CatalogueEntity toCatalogueEntity(CatalogueRequest catalogueRequest);
    CatalogueDTO toCatalogueDTO(CatalogueEntity catalogueEntity);
}
