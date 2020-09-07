package ratz.springframework.ratzpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Speciality;
import ratz.springframework.ratzpetclinic.repositories.SpecialtyRepository;
import ratz.springframework.ratzpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Integer integer) {
        return specialtyRepository.findById(integer).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        specialtyRepository.deleteById(integer);
    }
}
