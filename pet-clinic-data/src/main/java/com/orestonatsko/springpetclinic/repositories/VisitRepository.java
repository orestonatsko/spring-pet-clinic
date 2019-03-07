package com.orestonatsko.springpetclinic.repositories;

import com.orestonatsko.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
