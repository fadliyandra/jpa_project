package com.example.demo.repository;


import com.example.demo.entity.Siswa;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;


@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {

  List<Siswa>findByFirstName(String firstname);
  Siswa findByFirstNameAndLAstName (String firstName, String lastName);


}
