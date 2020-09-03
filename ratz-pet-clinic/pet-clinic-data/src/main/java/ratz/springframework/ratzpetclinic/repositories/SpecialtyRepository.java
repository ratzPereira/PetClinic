package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Integer> {
}
