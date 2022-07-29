package com.example.model;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class NoArgsConstructorWood {

    // equivalent to:

    // public Wood() {
    //     super();
    // }

}
