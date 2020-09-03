package ratz.springframework.ratzpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.PetType;
import ratz.springframework.ratzpetclinic.repositories.PetTypeRepository;
import ratz.springframework.ratzpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class PetTypeSDJpaService implements PetTypeService {


    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();

        petTypeRepository.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public PetType findById(Integer integer) {
        return petTypeRepository.findById(integer).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        petTypeRepository.deleteById(integer);
    }
}
