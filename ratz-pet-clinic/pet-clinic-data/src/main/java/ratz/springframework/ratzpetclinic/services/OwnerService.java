package ratz.springframework.ratzpetclinic.services;

import ratz.springframework.ratzpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Integer>{

    Owner findByLastName(String lastName);

}
