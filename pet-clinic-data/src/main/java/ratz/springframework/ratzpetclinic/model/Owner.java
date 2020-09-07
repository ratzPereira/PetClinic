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
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

}
