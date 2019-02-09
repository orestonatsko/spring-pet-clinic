package com.orestonatsko.springpetclinic.services;

import com.orestonatsko.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);
}
