package ratz.springframework.ratzpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ratz.springframework.ratzpetclinic.model.Owner;
import ratz.springframework.ratzpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {


    @Mock
    OwnerService ownerService;

    @Mock
    OwnersController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        //each time one test is made, this initializes a mock environment for
        //controler, se we can test a lot of diff interactions

        owners = new HashSet<>();
        owners.add(Owner.builder().id(1).build());
        owners.add(Owner.builder().id(2).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }



//    @Test
//    void findOwners() throws Exception {
//
//        mockMvc.perform(get("/owners/find"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/find"))
//                .andExpect(model().attributeExists("owner"));
//
//        verifyNoInteractions(ownerService);
//    }

    @Test
    void displayOwner() throws Exception {

        lenient().when(ownerService.findById(anyInt())).thenReturn(Owner.builder().id(1).build());
        ownerService.findAll();

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk());
        //.andExpect(view().name("owners/ownerDetails"))
       //.andExpect(model().attribute("owner", Matchers.hasProperty("id" , is(1))));
    }
}