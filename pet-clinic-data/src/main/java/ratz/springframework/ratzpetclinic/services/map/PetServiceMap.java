package ratz.springframework.ratzpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Pet;
import ratz.springframework.ratzpetclinic.services.PetService;

import java.util.Set;

@Service
@Profile({"default" , "map"})
public class PetServiceMap extends AbstractMapService<Pet, Integer> implements PetService {


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
        return super.save(object);
    }

    @Override
    public Pet findById(Integer id) {
        return super.findById(id);
    }
}
