package com.izak.restaurant_catalouge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.izak.restaurant_catalouge.entities.CatalogueEntity;

@Repository
public interface CatalogueRepo extends JpaRepository<CatalogueEntity, Long> {

    @Query("SELECT c FROM CatalogueEntity c WHERE c.restaurantId = ?1")
    List<CatalogueEntity> findByRstaurantId(Long id);
    
}
