package com.example.demo.service;


import com.example.demo.entity.Siswa;
import com.example.demo.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SiswaService {

    @Autowired
    SiswaRepository siswaRepository;

    public List<Siswa> getAllSiswa(){
       return siswaRepository.findAll();
    }

}
