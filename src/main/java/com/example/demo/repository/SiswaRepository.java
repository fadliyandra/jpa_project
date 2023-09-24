package com.example.demo.repository;


import com.example.demo.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {

  List<Siswa>findByFirstName(String firstname);
  Siswa findByFirstNameAndLastName(String firstName, String lastName);



}
