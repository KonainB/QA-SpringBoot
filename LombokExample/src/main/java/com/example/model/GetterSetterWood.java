package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GetterSetterWood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean coniferous;

    private String colour;

    private String name;

    private int age;

    private int weight;

    private boolean artificial;

    private boolean soft;

    // equivalent to:

    // public String getColour() { return colour; }
    // public void setColour(String colour) { this.colour = colour; }
    // etc.

}
