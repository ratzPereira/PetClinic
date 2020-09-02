package ratz.springframework.ratzpetclinic.services.map;


import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.PetType;
import ratz.springframework.ratzpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Integer> implements PetTypeService {


    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Integer id) {
        return super.findById(id);
    }
}
