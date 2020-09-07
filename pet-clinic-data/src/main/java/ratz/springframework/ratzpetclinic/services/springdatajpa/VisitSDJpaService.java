package ratz.springframework.ratzpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Visit;
import ratz.springframework.ratzpetclinic.repositories.VisitRepository;
import ratz.springframework.ratzpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class VisitSDJpaService implements VisitService {


    private final VisitRepository visitRepository;


    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }



    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();

        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Integer integer) {
        return visitRepository.findById(integer).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        visitRepository.deleteById(integer);
    }
}
