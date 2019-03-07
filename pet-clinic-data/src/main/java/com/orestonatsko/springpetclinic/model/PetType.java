package com.orestonatsko.springpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

}
