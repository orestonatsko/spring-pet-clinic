package com.orestonatsko.springpetclinic.services.map;

import com.orestonatsko.springpetclinic.model.Speciality;
import com.orestonatsko.springpetclinic.model.Vet;
import com.orestonatsko.springpetclinic.services.SpecialtyService;
import com.orestonatsko.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtyService specialityService;

    @Override
    public Vet findById(Long id) {
        return super.findBId(id);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialities().size() > 0){
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet.getId(), vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}
