package com.orestonatsko.springpetclinic.services.springdatajpa;

import com.orestonatsko.springpetclinic.model.Speciality;
import com.orestonatsko.springpetclinic.repositories.SpecialityRepository;
import com.orestonatsko.springpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class SpecialitySDJpaService implements SpecialtyService {
    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
