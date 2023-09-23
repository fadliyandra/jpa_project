package com.example.demo.repository;


import com.example.demo.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {



}
