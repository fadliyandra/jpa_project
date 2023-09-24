package com.example.demo.controller;


import com.example.demo.entity.Siswa;
import com.example.demo.request.CreateSiswaRequest;
import com.example.demo.request.UpdateSiswaRequest;
import com.example.demo.response.SiswaResponse;
import com.example.demo.service.SiswaService;
import jakarta.validation.Valid;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.xml.SimpleSaxErrorHandler;
import org.springframework.web.bind.annotation.*;

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
//
//    @GetMapping("/getAll")
//    public List<Siswa>getAllSiswa(){
//        return siswaService.getAllSiswa();
//    }




    @GetMapping("getAll")
    public List<SiswaResponse> getAllSiswa(){
       List<Siswa> siswaList = siswaService.getAllSiswa();
       List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();

       siswaList.stream().forEach(siswa ->{
           siswaResponseList.add(new SiswaResponse(siswa));
       });
       return siswaResponseList;

    }

    @PostMapping("create")
    public SiswaResponse createSiswa (@Valid @RequestBody CreateSiswaRequest createSiswaRequest){
        Siswa siswa = siswaService.createSiswa(createSiswaRequest);

        return new SiswaResponse(siswa);

    }

    @PutMapping("update")
    public SiswaResponse updateSiswa (@Valid @RequestBody UpdateSiswaRequest updateSiswaRequest){

        Siswa siswa = siswaService.updateSiswa(updateSiswaRequest);

        return new SiswaResponse(siswa);
    }

//    @DeleteMapping("delete")
//    public String deleteSiswa(@RequestParam long id){
//        return siswaService.deleteSiswa(id);
//
//    }

    @DeleteMapping("delete/{id}")
    public String deleteSiswa(@PathVariable long id){
        return siswaService.deleteSiswa(id);
    }

    @GetMapping("getByFirstName/{firstName}")
    public List<SiswaResponse> getByFirstName(@PathVariable String firstName){
        List<Siswa> siswaList  = siswaService.getByFirstName(firstName);

        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();

        siswaList.stream().forEach(siswa ->{
            siswaResponseList.add(new SiswaResponse(siswa));
        });
        return siswaResponseList;

    }

    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
    public SiswaResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){


    }






}
