package ratz.springframework.ratzpetclinic.services;


import java.util.Set;

//its like crudRepository Spring interface!
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
