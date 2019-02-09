package com.orestonatsko.springpetclinic.services.map;

import com.orestonatsko.springpetclinic.model.Owner;
import com.orestonatsko.springpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(owner.getId(), owner);
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

