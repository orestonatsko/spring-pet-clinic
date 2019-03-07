package com.orestonatsko.springpetclinic.repositories;

import com.orestonatsko.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
