package ratz.springframework.ratzpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ratz.springframework.ratzpetclinic.model.Owner;
import ratz.springframework.ratzpetclinic.repositories.OwnerRepository;
import ratz.springframework.ratzpetclinic.repositories.PetRepository;
import ratz.springframework.ratzpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Pear";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;


    @InjectMocks // will inject all dependencies
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        Owner returnOwner = Owner.builder().id(1).lastName(LAST_NAME).build();

        //digo a mock que quando o OwnerRepo encontrar algum, quero que o retorne.
        //para testar a linha 33 da class
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner pear = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, pear.getLastName());

        //do a verify of a mock interaction, is redundant in this case
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1).build());
        returnOwnersSet.add(Owner.builder().id(2).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyInt())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyInt())).thenReturn(Optional.empty());

        Owner owner = service.findById(1);
        assertNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
        //just to make doubly sure
        verify(ownerRepository).save(any());

    }

    @Test
    void delete() {

        service.delete(returnOwner);

        //the times default is 1, i just did to show
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1);
        //the times default is 1, i just did to show
        verify(ownerRepository,times(1)).deleteById(anyInt());
    }
}