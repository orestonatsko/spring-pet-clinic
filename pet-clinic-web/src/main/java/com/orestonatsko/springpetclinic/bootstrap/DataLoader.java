package com.orestonatsko.springpetclinic.bootstrap;

import com.orestonatsko.springpetclinic.model.*;
import com.orestonatsko.springpetclinic.services.OwnerService;
import com.orestonatsko.springpetclinic.services.PetTypeService;
import com.orestonatsko.springpetclinic.services.VetService;
import com.orestonatsko.springpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            createOwnersAndPetsAndVisits();
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

    private void createOwnersAndPetsAndVisits() {
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

        Pet dogPet = createPet(owner1, dog, "Rob", 1L);

        Visit visit1 = new Visit();
        visit1.setId(1L);
        visit1.setDate(LocalDate.now());
        visit1.setPet(dogPet);
        visit1.setDescription("Very good dog");

        visitService.save(visit1);

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

        Pet catPet = createPet(owner2, cat, "Dolly", 2L);

        Visit visit2 = new Visit();
        visit2.setId(2L);
        visit2.setDate(LocalDate.now());
        visit2.setPet(catPet);
        visit2.setDescription("Very good cat");

        visitService.save(visit2);

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

       Pet rabbitPet = createPet(owner3, rabbit, "Some rabbit",3L);

        Visit visit3 = new Visit();
        visit3.setId(3L);
        visit3.setDate(LocalDate.now());
        visit3.setPet(rabbitPet);
        visit3.setDescription("Very good rabbit");

        visitService.save(visit3);

        System.out.println("Loaded Owners, Pets and Visits...");

    }
    private Pet createPet(Owner owner, PetType petType, String petName, Long petId) {
        petTypeService.save(petType);
        Pet pet = new Pet();
        pet.setId(petId);
        pet.setName(petName);
        pet.setPetType(petType);
        owner.getPets().add(pet);
        pet.setOwner(owner);
        return pet;
    }
}
