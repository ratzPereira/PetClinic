package ratz.springframework.ratzpetclinic.services;

import ratz.springframework.ratzpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Integer id);

    Owner save (Owner owner);

    Set<Owner> findAll();

}
