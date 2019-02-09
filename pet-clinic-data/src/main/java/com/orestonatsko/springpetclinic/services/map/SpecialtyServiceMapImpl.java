package com.orestonatsko.springpetclinic.services.map;

import com.orestonatsko.springpetclinic.model.Speciality;
import com.orestonatsko.springpetclinic.services.SpecialtyService;

import java.util.Set;

public class SpecialtyServiceMapImpl extends AbstractMapService<Speciality, Long> implements SpecialtyService {

    @Override
    public Speciality findById(Long id) {
        return super.findBId(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality.getId(), speciality);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }
}
