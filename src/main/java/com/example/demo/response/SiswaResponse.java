package com.example.demo.response;

import com.example.demo.entity.Siswa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
//@Data
public class SiswaResponse {


    private long id;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;

    private String email;

    private String fullName;

    public SiswaResponse (Siswa siswa){

        this.id = siswa.getId();
        this.firstName= siswa.getFirstName();
        this.lastName = siswa.getLastName();
        this.email = siswa.getEmail();
        this.fullName = siswa.getFirstName() + " " + siswa.getLastName();
    }


}
