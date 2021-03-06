package com.orestonatsko.springpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pet")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="pet")
    private Set<Visit> visits = new HashSet<>();

}
