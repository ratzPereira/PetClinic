package ratz.springframework.ratzpetclinic.services;


import ratz.springframework.ratzpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Integer id);

    Pet save (Pet pet);

    Set<Pet> findAll();

}
