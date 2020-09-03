package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
}
