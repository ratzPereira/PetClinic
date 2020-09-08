package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.Owner;

import java.util.List;


public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
