package com.orestonatsko.springpetclinic.model;

import java.util.Set;

public class Owner extends Person {
    private Set<Set> pets;

    public Set<Set> getPets() {
        return pets;
    }

    public void setPets(Set<Set> pets) {
        this.pets = pets;
    }
}
