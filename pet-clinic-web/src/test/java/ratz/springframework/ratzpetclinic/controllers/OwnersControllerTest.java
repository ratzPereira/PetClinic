package ratz.springframework.ratzpetclinic.controllers;

import org.hamcrest.Matchers;
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

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

       // when(ownerService.findById(anyInt())).thenReturn(Owner.builder().id(1).build());
        ownerService.findAll();

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk());
        //.andExpect(view().name("owners/ownerDetails"))
       //.andExpect(model().attribute("owner", Matchers.hasProperty("id" , is(1))));
    }
}