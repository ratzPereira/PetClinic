package ratz.springframework.ratzpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ratz.springframework.ratzpetclinic.model.Speciality;
import ratz.springframework.ratzpetclinic.model.Vet;
import ratz.springframework.ratzpetclinic.services.SpecialityService;
import ratz.springframework.ratzpetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default" , "map"})
public class VetServiceMap extends AbstractMapService <Vet, Integer> implements VetService {

    public final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {

        return super.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {

        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() >0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() ==null ){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Integer id) {

        return super.findById(id);
    }
}
