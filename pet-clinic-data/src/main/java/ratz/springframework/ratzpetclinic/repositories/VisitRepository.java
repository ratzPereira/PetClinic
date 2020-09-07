package ratz.springframework.ratzpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ratz.springframework.ratzpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Integer> {
}
