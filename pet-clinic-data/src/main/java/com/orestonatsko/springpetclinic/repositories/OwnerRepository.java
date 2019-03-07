package com.orestonatsko.springpetclinic.repositories;

import com.orestonatsko.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
