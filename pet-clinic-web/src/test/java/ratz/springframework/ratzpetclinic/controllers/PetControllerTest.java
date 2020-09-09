package ratz.springframework.ratzpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ratz.springframework.ratzpetclinic.model.Owner;
import ratz.springframework.ratzpetclinic.model.Pet;
import ratz.springframework.ratzpetclinic.model.PetType;
import ratz.springframework.ratzpetclinic.services.OwnerService;
import ratz.springframework.ratzpetclinic.services.PetService;
import ratz.springframework.ratzpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1).name("Dog").build());
        petTypes.add(PetType.builder().id(2).name("Cat").build());

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

    }

//    @Test
//    void initCreationForm() throws Exception {
//
//        when(ownerService.findById(anyInt())).thenReturn(owner);
//        when(petTypeService.findAll()).thenReturn(petTypes);
//
//        mockMvc.perform(get("/owners/1/pets/new"))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("owner"))
//                .andExpect(model().attributeExists("pet"))
//                .andExpect(view().name("pets/createOrUpdatePetForm"));
//    }

//    @Test
//    void processCreationForm() throws Exception {
//        lenient().when(ownerService.findById(anyInt())).thenReturn(owner);
//        lenient(). when(petTypeService.findAll()).thenReturn(petTypes);
//
//        mockMvc.perform(post("/owners/1/pets/new"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"));
//
//        verify(petService).save(any());
//    }

    @Test
    void initUpdateForm() throws Exception {
        lenient().when(ownerService.findById(anyInt())).thenReturn(owner);
        lenient().when(petTypeService.findAll()).thenReturn(petTypes);
        lenient().when(petService.findById(anyInt())).thenReturn(Pet.builder().id(2).build());

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

//    @Test
//    void processUpdateForm() throws Exception {
//        lenient().when(ownerService.findById(anyInt())).thenReturn(owner);
//        lenient().when(petTypeService.findAll()).thenReturn(petTypes);
//
//        mockMvc.perform(post("/owners/1/pets/1/edit"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"));
//
//        verify(petService).save(any());
//    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }
}