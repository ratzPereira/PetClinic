package ratz.springframework.ratzpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Vet;
import ratz.springframework.ratzpetclinic.repositories.VetRepository;
import ratz.springframework.ratzpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class VetsSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetsSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();

        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Integer integer) {
        return vetRepository.findById(integer).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        vetRepository.deleteById(integer);
    }
}
