package com.example.demo.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateSiswaRequest {

    @JsonProperty("first_name")
    @NotBlank(message = "tidak  boleh kosong")
    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;



}
