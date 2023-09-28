package com.example.demo.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateSiswaRequest {  //represenyasi data untuk membuat data baru

    @JsonProperty("first_name") //mapping
    @NotBlank(message = "tidak  boleh kosong")  //anotasi validasi
    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<CreateSubjectRequest> subjectsLearning;  //object list subject




}
