package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.Owner;


public interface OwnerRepository extends CrudRepository<Owner, Integer> {


}
