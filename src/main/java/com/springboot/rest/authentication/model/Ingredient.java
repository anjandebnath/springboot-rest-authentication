package com.springboot.rest.authentication.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ingredient")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Ingredient {

    @Id
    @Column(length = 4)
    private String id;

    private String name;

    private Integer typeId;


}
