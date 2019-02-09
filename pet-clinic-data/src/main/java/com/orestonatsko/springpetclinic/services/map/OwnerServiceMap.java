package com.orestonatsko.springpetclinic.services.map;

import com.orestonatsko.springpetclinic.model.Owner;
import com.orestonatsko.springpetclinic.model.Pet;
import com.orestonatsko.springpetclinic.services.OwnerService;
import com.orestonatsko.springpetclinic.services.PetService;
import com.orestonatsko.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String name) {
        for (Owner owner : map.values()) {
            if (owner.getLastName().equalsIgnoreCase(name)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findBId(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        petTypeService.save(pet.getPetType());
                    }
                } else {
                    throw new RuntimeException("PetType is required");
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
            return super.save(owner.getId(), owner);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }
}

