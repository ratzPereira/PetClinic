package ratz.springframework.ratzpetclinic.services;

import ratz.springframework.ratzpetclinic.model.Vet;
import java.util.Set;

public interface VetService {

    Vet findById(Integer id);

    Vet save (Vet vet);

    Set<Vet> findAll();

}
