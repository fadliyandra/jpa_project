package com.example.demo.entity;


import com.example.demo.request.CreateSiswaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "siswa")

public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="email")
    private String email;


    //@OneToOne(fetch = FetchType.LAZY) ???
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "siswa")
    private List<Subject> learningSubject;

    public Siswa(CreateSiswaRequest createSiswaRequest) {
        this.firstName = createSiswaRequest.getFirstName();
        this.lastName = createSiswaRequest.getLastName();
        this.email = createSiswaRequest.getEmail();

     }
}
