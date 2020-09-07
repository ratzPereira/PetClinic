package ratz.springframework.ratzpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Pet;
import ratz.springframework.ratzpetclinic.repositories.PetRepository;
import ratz.springframework.ratzpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile(("springdatajpa"))
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;


    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Integer integer) {
        return petRepository.findById(integer).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        petRepository.deleteById(integer);
    }
}
