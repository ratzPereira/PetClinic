package ratz.springframework.ratzpetclinic.services.map;

import ratz.springframework.ratzpetclinic.model.Pet;
import ratz.springframework.ratzpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Integer> implements CrudService<Pet, Integer> {


    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {

        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Integer id) {
        return super.findById(id);
    }
}
