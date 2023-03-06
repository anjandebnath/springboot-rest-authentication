package com.springboot.rest.authentication.controllers;

import com.springboot.rest.authentication.model.EIngType;
import com.springboot.rest.authentication.model.Ingredient;
import com.springboot.rest.authentication.model.IngredientType;
import com.springboot.rest.authentication.payload.request.IngredientRequest;
import com.springboot.rest.authentication.repository.IngredientRepository;
import com.springboot.rest.authentication.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/taco")
public class TacoController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    TypeRepository typeRepository;

    @PostMapping("/create_types")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createIngredients() {

        try{
            // get Ingredient type by value
            typeRepository.save(new IngredientType(EIngType.WRAP));
            typeRepository.save(new IngredientType(EIngType.CHEESE));
            typeRepository.save(new IngredientType(EIngType.PROTEIN));
            typeRepository.save(new IngredientType(EIngType.VEGGIES));
            typeRepository.save(new IngredientType(EIngType.SAUCE));

            return new ResponseEntity<>("Type save success", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create_ingredients")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createIngredients(@Valid @RequestBody IngredientRequest ingredientRequest) {

        try{
            // get Ingredient type by value
            IngredientType ingredientType = switch (ingredientRequest.getType()) {
                case "wrap" -> typeRepository.findByType(EIngType.WRAP);
                case "prot" -> typeRepository.findByType(EIngType.PROTEIN);
                case "vegi" -> typeRepository.findByType(EIngType.VEGGIES);
                case "sauce" -> typeRepository.findByType(EIngType.SAUCE);
                default -> typeRepository.findByType(EIngType.CHEESE);
            };

            // Create Ingredient by Admin
            Ingredient ingEntity = new Ingredient(ingredientRequest.getId(),
                    ingredientRequest.getName(), ingredientType.getId());

            ingredientRepository.save(ingEntity);
            return new ResponseEntity<>("ingredient save success", HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get_ingredients")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Ingredient>> getIngredients() {

        try{
            List<Ingredient> ingredients = new ArrayList<Ingredient>();
            ingredientRepository.findAll().forEach(ingredients::add);

            if(ingredients.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
