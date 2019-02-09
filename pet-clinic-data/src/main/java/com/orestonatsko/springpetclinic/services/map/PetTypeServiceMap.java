package com.orestonatsko.springpetclinic.services.map;

import com.orestonatsko.springpetclinic.model.PetType;
import com.orestonatsko.springpetclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public PetType findById(Long id) {
        return super.findBId(id);
    }

    @Override
    public PetType save(PetType pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }
}
