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
@AllArgsConstructor
//@Data
@ToString
public class SiswaResponse {


    private long id;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<SubjectResponse> learningSubjects;


    public SiswaResponse (Siswa siswa){

        this.id = siswa.getId();
        this.firstName= siswa.getFirstName();
        this.lastName = siswa.getLastName();
        this.email = siswa.getEmail();

        this.street = siswa.getAddress().getStreet();
        this.city = siswa.getAddress().getCity();

        if (siswa.getLearningSubjects() != null){
            learningSubjects = new ArrayList<SubjectResponse>();
            for (Subject subject : siswa.getLearningSubjects()){
                learningSubjects.add(new SubjectResponse(subject));
            }
        }



    }


}
