package com.example.model;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
public class ToStringWood {

/*  equivalent to:

    @Override
    public String toString() {...}

    @Override
    public int hashCode() {...}

    @Override
    public boolean equals(Object obj) {...}
*/
}
