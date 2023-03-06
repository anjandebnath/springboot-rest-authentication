package com.springboot.rest.authentication.repository;

import com.springboot.rest.authentication.model.EIngType;
import com.springboot.rest.authentication.model.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<IngredientType, Long> {
    IngredientType findByType(EIngType name);
}
