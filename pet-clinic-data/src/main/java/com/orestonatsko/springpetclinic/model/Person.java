package com.orestonatsko.springpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
