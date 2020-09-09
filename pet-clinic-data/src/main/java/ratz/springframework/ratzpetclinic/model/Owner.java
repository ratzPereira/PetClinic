package ratz.springframework.ratzpetclinic.model;



import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Owners")
public class Owner extends Person {

    //builder pattern
    @Builder
    public Owner(Integer id, String firstName, String lastName, Set<Pet> pets,
                 Integer phoneNumber, String address, String city) {
        super(id, firstName, lastName);  //vem de person
        this.pets = pets;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;

        if(pets != null) {
            this.pets = pets;
        }
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;



    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */

    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */


    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }
}
