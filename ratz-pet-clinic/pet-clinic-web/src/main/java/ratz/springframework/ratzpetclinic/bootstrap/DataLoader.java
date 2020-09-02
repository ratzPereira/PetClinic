package ratz.springframework.ratzpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ratz.springframework.ratzpetclinic.model.*;
import ratz.springframework.ratzpetclinic.services.OwnerService;
import ratz.springframework.ratzpetclinic.services.PetTypeService;
import ratz.springframework.ratzpetclinic.services.SpecialityService;
import ratz.springframework.ratzpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialitiesService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0 ){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType donkey = new PetType();
        dog.setName("Donkey");
        PetType savedDonkeyPetType = petTypeService.save(donkey);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality dentist = new Speciality();
        dentist.setDescription("Dentist");
        Speciality savedDentist = specialitiesService.save(dentist);

        Speciality surgeon = new Speciality();
        surgeon.setDescription("Surgeon");
        Speciality savedSurgeon = specialitiesService.save(surgeon);




        Owner owner = new Owner();
        owner.setFirstName("João");
        owner.setLastName("Pereira");
        owner.setAdress("Carreira Longa");
        owner.setCity("Vila Real");
        owner.setPhoneNumber(913439919);

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Carolina");
        owner1.setLastName("Martins");
        owner1.setAdress("Canada de São Vicente");
        owner1.setCity("Angra");
        owner1.setPhoneNumber(912234052);

        ownerService.save(owner1);


        Pet nasus = new Pet();
        nasus.setOwner(owner);
        nasus.getBirthDate(LocalDate.now());
        nasus.setName("Nasus");
        nasus.setPetType(dog);
        owner.getPets().add(nasus);

        Pet burroAnao = new Pet();
        burroAnao.setName("Ainda nao tem");
        burroAnao.setPetType(donkey);
        burroAnao.setBirthDate(LocalDate.now());
        burroAnao.setOwner(owner1);
        owner1.getPets().add(burroAnao);



        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setFirstName("Jessica");
        vet.setLastName("Luiz");
        vet.getSpecialities().add(dentist);


        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Maria");
        vet1.setLastName("Antonieta");
        vet1.getSpecialities().add(savedSurgeon);

        vetService.save(vet1);

        System.out.println("Loaded Vets....");
    }
}
