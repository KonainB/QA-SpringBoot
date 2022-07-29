package com.example.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class AllArgsConstructorWood {

/*  equivalent to:

    public Wood(Long id, boolean coniferous, String colour, String name, int age, int weight, boolean artificial, boolean soft) {
        super();
        this.id = id;
        this.coniferous = coniferous;
        this.colour = colour;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.artificial = artificial;
        this.soft = soft;
    }
*/
}
