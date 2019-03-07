package com.orestonatsko.springpetclinic.repositories;

import com.orestonatsko.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
