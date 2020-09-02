package ratz.springframework.ratzpetclinic.services.map;

import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Owner;
import ratz.springframework.ratzpetclinic.model.Pet;
import ratz.springframework.ratzpetclinic.services.OwnerService;
import ratz.springframework.ratzpetclinic.services.PetService;
import ratz.springframework.ratzpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Integer> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {

        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet-> {
                    if(pet.getPetType() != null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }else {
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
