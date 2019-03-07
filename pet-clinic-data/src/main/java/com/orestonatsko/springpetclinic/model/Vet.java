package com.orestonatsko.springpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns =  @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;

    public Vet() {
        this.specialities = new HashSet<>();
    }

}
