package com.orestonatsko.springpetclinic.repositories;

import com.orestonatsko.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
