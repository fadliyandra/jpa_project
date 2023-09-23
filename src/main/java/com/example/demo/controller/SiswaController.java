package com.example.demo.controller;


import com.example.demo.entity.Siswa;
import com.example.demo.response.SiswaResponse;
import com.example.demo.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/siswa/")
public class SiswaController {

//    @Value("${app.name:Default Demo App}")
//    private String appName;
//
//    @GetMapping("/get")
//    public SiswaResponse getSiswa(){
//        SiswaResponse siswaResponse = new SiswaResponse(1,"fadli","yandra");
//
//        return siswaResponse;
//
//    }

    @Autowired
    SiswaService siswaService;

    @GetMapping("/getAll")
    public List<SiswaResponse> getAllSiswa(){
       List<Siswa> siswaList = siswaService.getAllSiswa();
       List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();

       siswaList.stream().forEach(siswa ->{
           siswaResponseList.add(new SiswaResponse(siswa));
       });
       return siswaResponseList;

    }

}
