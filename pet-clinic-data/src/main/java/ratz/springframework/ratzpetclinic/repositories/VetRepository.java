package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Integer> {
}
