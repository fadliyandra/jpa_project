package com.example.demo.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateSiswaRequest {

    @NotNull(message = "siswa id is required")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
