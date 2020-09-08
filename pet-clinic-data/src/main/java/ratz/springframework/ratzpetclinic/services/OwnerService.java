package ratz.springframework.ratzpetclinic.services;

import ratz.springframework.ratzpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Integer>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
