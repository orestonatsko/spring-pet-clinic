package com.orestonatsko.springpetclinic.bootstrap;

import com.orestonatsko.springpetclinic.model.*;
import com.orestonatsko.springpetclinic.services.OwnerService;
import com.orestonatsko.springpetclinic.services.PetTypeService;
import com.orestonatsko.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            createOwnersAndPets();
            createVets();
        }
    }

    private void createVets() {
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Karl");
        vet1.setLastName("Mensh");
        Speciality speciality1 = new Speciality();
        speciality1.setId(1L);
        speciality1.setDescription("dentistry");
        vet1.getSpecialities().add(speciality1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ira");
        vet2.setLastName("Kerch");
        Speciality speciality2 = new Speciality();
        speciality2.setId(2L);
        speciality2.setDescription("surgery");
        vet2.getSpecialities().add(speciality1);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Oleh");
        vet3.setLastName("Gorniy");
        Speciality speciality3 = new Speciality();
        speciality3.setId(3L);
        speciality3.setDescription("radiology");
        vet3.getSpecialities().add(speciality3);
        vetService.save(vet3);

        System.out.println("Loaded Vets...");
    }

    private void createOwnersAndPets() {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Orest");
        owner1.setLastName("Onatsko");
        owner1.setAddress("123 Horodotska");
        owner1.setCity("Lviv");
        owner1.setTelephone("0567865434");
        ownerService.save(owner1);

        PetType dog = new PetType();
        dog.setId(1L);
        dog.setName("dog");
        createPet(owner1, dog, "Rob", 1L);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Lida");
        owner2.setLastName("Kerish");
        owner2.setAddress("45 Levandivka");
        owner2.setCity("Lviv");
        owner2.setTelephone("0678843565");
        ownerService.save(owner2);

        PetType cat = new PetType();
        cat.setId(2L);
        cat.setName("cat");
        createPet(owner2, cat, "Dolly", 2L);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Ostap");
        owner3.setLastName("Lister");
        owner3.setAddress("45 Linkolna");
        owner3.setCity("Lviv");
        owner3.setTelephone("0632456464");
        ownerService.save(owner3);

        PetType rabbit = new PetType();
        rabbit.setId(3L);
        rabbit.setName("rabbit");
        createPet(owner3, rabbit, "Some rabbit",3L);

        System.out.println("Loaded Owners and Pets...");

    }

    private void createPet(Owner owner, PetType petType, String petName, Long petId) {
        petTypeService.save(petType);
        Pet pet = new Pet();
        pet.setId(petId);
        pet.setName(petName);
        pet.setPetType(petType);
        owner.getPets().add(pet);
        pet.setOwner(owner);
    }
}
