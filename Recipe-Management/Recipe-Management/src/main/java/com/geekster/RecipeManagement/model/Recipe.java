package com.geekster.RecipeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipe_id;
    @NotBlank(message = "recipe name not blank")
    @NotNull(message = "recipe name not null")
    private String recipe_name;
    @NotBlank(message = "ingredients name not blank")
    @NotNull(message = "ingredients name not null")
    private String ingredients;
    @NotBlank(message = "instruction must not be blank")
    @NotNull(message = "instruction name not null")
    private String instruction;

}
