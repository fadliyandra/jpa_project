package com.example.demo.repository;


import com.example.demo.entity.Address;
import com.example.demo.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository  //mengkases dan mengelola data
public interface SiswaRepository extends JpaRepository<Siswa, Long> {   //crud

  List<Siswa>findByFirstName(String firstname);

  Siswa findByLastNameAndFirstName(String lastName, String firstName);

  List<Siswa> findByFirstNameOrLastName (String firstName, String lastName);

  List<Siswa>findByFirstNameIn(List<String> firstNames);

  List<Siswa> findByFirstNameContains(String firstNames);

  List<Siswa> findByFirstNameStartsWith(String firstName);

  //select use jpql
  @Query("From Siswa where firstName = :firstname and lastName = :lastName")
  Siswa getByLastNameAndFirstName(String lastName, @Param("firstname") String firstName);

  //update query with jpql
  @Modifying
  @Transactional
  @Query("Update Siswa set firstName = :firstName where id = :id")
  Integer updateFirstName (Long id, String firstName);

  @Modifying
  @Transactional
  @Query("Delete From Siswa where firstName = :firstName")
  Integer deletebyFirstName (String firstName);

  List<Siswa> findByAddressCity(String city);

  @Query("From Siswa where address.city = :city")
  List<Siswa> getByAddressCity (String city);


}
