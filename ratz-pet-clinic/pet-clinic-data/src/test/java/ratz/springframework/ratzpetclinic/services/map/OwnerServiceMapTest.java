package ratz.springframework.ratzpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ratz.springframework.ratzpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {


    OwnerServiceMap ownerServiceMap;
    final Integer ownerId = 1;
    final String lastName = "Pear";

    // fazer a dependency injection \/
    @BeforeEach
    void setUp() {
        // new PetTypeMapService(),new PetServiceMap() <- porque a class tem as 2 dependecias
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(),new PetServiceMap());

        //this will initialize OwnerMapService and put one owner object into it
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
       Set<Owner> ownerSet =  ownerServiceMap.findAll();

       assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        //dont forget that the method setUp(@before each) will run and create 1 owner
        ownerServiceMap.deleteById(ownerId);

        //verificar se apagou o owner ( se o size é 0)
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {

        //dont forget that the method setUp(@before each) will run and create 1 owner
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        //verificar se apagou o owner ( se o size é 0)
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        int id = 2;
        //crio outro owner com o id 2
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId(){

        //create a new owner without giving id
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        //checking if that owner exist/ it not null
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastName() {
      Owner pear =  ownerServiceMap.findByLastName(lastName);

        assertNotNull(pear);

        assertEquals(ownerId,pear.getId());
    }

    @Test
    void findByLastNameNotFound() {

        //testing if we get null if we try to find something that does't exist
        Owner pear =  ownerServiceMap.findByLastName("foo");

        assertNull(pear);

    }
}