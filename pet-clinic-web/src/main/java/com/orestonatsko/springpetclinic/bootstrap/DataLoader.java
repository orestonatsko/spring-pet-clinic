package com.orestonatsko.springpetclinic.bootstrap;

import com.orestonatsko.springpetclinic.model.Owner;
import com.orestonatsko.springpetclinic.model.Vet;
import com.orestonatsko.springpetclinic.services.OwnerService;
import com.orestonatsko.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Owners
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Orest");
        owner1.setLastName("Onatsko");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Lida");
        owner2.setLastName("Kerish");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Ostap");
        owner3.setLastName("Lister");

        ownerService.save(owner3);

        //Vets
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Karl");
        vet1.setLastName("Mensh");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ira");
        vet2.setLastName("Kerch");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Oleh");
        vet3.setLastName("Gorniy");

        vetService.save(vet3);

        Vet vet4 = new Vet();
        vet4.setId(4L);
        vet4.setFirstName("Stas");
        vet4.setLastName("Derish");

        vetService.save(vet3);

    }
}
