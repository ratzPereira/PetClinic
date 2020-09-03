package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {
}
