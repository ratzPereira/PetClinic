package ratz.springframework.ratzpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ratz.springframework.ratzpetclinic.model.Owner;
import ratz.springframework.ratzpetclinic.model.Vet;
import ratz.springframework.ratzpetclinic.services.OwnerService;
import ratz.springframework.ratzpetclinic.services.VetService;

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

        Owner owner = new Owner();
        owner.setFirstName("João");
        owner.setLastName("Pereira");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Carolina");
        owner1.setLastName("Martins");

        ownerService.save(owner1);

        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setFirstName("Jessica");
        vet.setLastName("Luiz");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Maria");
        vet1.setLastName("Antonieta");

        vetService.save(vet1);

        System.out.println("Loaded Vets....");

    }
}
