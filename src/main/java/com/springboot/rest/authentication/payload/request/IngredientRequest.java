package com.springboot.rest.authentication.payload.request;

import com.springboot.rest.authentication.model.EIngType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class IngredientRequest {

    private String id;

    private String name;

    private String type;
}
