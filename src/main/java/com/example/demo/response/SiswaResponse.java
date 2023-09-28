package com.example.demo.response;

import com.example.demo.entity.Siswa;
import com.example.demo.entity.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor //constructor dengan semua property
//@Data
@ToString  //representasi dari strig object
public class SiswaResponse {


    private long id;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;    //field response

    private String email;

    private String street;

    private String city;

    private List<SubjectResponse> learningSubjects;


    public SiswaResponse (Siswa siswa){  //constructor membuat object berdasarkan data dari siswa

        this.id = siswa.getId();
        this.firstName= siswa.getFirstName();
        this.lastName = siswa.getLastName();
        this.email = siswa.getEmail();

        this.street = siswa.getAddress().getStreet();
        this.city = siswa.getAddress().getCity();

        if (siswa.getLearningSubjects() != null){
            learningSubjects = new ArrayList<SubjectResponse>(); //object array list kosong dari subject response untuk menyompan sibejct response
            for (Subject subject : siswa.getLearningSubjects()){
                learningSubjects.add(new SubjectResponse(subject));
            }
        }



    }


}
