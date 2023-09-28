package com.example.demo.controller;


import com.example.demo.entity.Siswa;
import com.example.demo.request.CreateSiswaRequest;
import com.example.demo.request.InQueryRequest;
import com.example.demo.request.UpdateSiswaRequest;
import com.example.demo.response.SiswaResponse;
import com.example.demo.service.SiswaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController  //pengontrol perimitaan http dan balikaan
@RequestMapping("/api/siswa/") //requast url dasar
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
    SiswaService siswaService;   //injesi servive
//
//    @GetMapping("/getAll")
//    public List<Siswa>getAllSiswa(){
//        return siswaService.getAllSiswa();
//    }




    @GetMapping("all")
    public List<SiswaResponse> getAllSiswa(){   //method


       List<Siswa> siswaList = siswaService.getAllSiswa();   //iterasis setian eleement siswa list
       List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();  //membuat object arraylist dengan tipe siswa response

       siswaList.stream().forEach(siswa ->{
           siswaResponseList.add(new SiswaResponse(siswa));  //??
       });
       return siswaResponseList;

    }

    @PostMapping("create")
    public SiswaResponse createSiswa (@Valid @RequestBody CreateSiswaRequest createSiswaRequest){  //menerima create sisawa requesy
        Siswa siswa = siswaService.createSiswa(createSiswaRequest);  //membuat object

        return new SiswaResponse(siswa); //kembalian

    }



    @PutMapping("update")
    public SiswaResponse updateSiswa (@Valid @RequestBody UpdateSiswaRequest updateSiswaRequest){  //method
        Siswa siswa = siswaService.updateSiswa(updateSiswaRequest);  //pemabruan data berdasarkan updateSiswaRequest
        return new SiswaResponse(siswa);  //d kembalikan menjasi object siswa response
    }



//    @PutMapping("update-firstname/{id}/{firstName}")
//    public String updateSiswaWithJpql (@PathVariable Long id, @PathVariable String firstName){
//        return siswaService.updateStudentWithJpql(id, firstName) + " Student(s) update";
//    }


//    @DeleteMapping("delete")
//    public String deleteSiswa(@RequestParam long id){
//        return siswaService.deleteSiswa(id);
//
//    }

//    @DeleteMapping("delete/{id}")
//    public String deleteSiswa(@PathVariable long id){
//        return siswaService.deleteSiswa(id);
//    }


    @DeleteMapping("delete/{id}")  //endpoint
    public String deleteSubject(@PathVariable long id){ //method dengan path variable
        return siswaService.deleteSubject(id); //return balik
    }




//    @GetMapping("getByFirstName/{firstName}")
//    public List<SiswaResponse> getByFirstName(@PathVariable String firstName){
//        List<Siswa> siswaList  = siswaService.getByFirstName(firstName);
//
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//        siswaList.stream().forEach(siswa ->{
//            siswaResponseList.add(new SiswaResponse(siswa));
//        });
//        return siswaResponseList;
//
//    }
//
//    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
//    public SiswaResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
//        return new SiswaResponse(siswaService.getByFirstNameAndLastName(firstName,lastName));
//    }
//
//
//
//
//    @GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
//    public List<SiswaResponse> getByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName){
//        List<Siswa> siswaList = siswaService.getByFirstNameOrLastName(firstName, lastName);
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//        siswaList.stream().forEach(siswa -> {
//            siswaResponseList.add(new SiswaResponse(siswa));
//        });
//        return siswaResponseList;
//    }
//
//    @GetMapping("get-by-first-name-in")
//    public List<SiswaResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
//
//
//
//
//        List<Siswa> siswaList = siswaService.getByFirstNameIn(inQueryRequest);
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//        siswaList.stream().forEach(siswa -> {
//            siswaResponseList.add(new SiswaResponse(siswa));
//        });
//
//
//
//        return siswaResponseList;
//
//    }
//
//
//        @GetMapping("getAllPagination")
//        public List<SiswaResponse> getAllSiswaWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
//
//        List<Siswa> siswaList = siswaService.getAllSiswaWithPagination(pageNo,pageSize);
//
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//        siswaList.stream().forEach(siswa -> {
//            siswaResponseList.add(new SiswaResponse(siswa));
//        });
//        return siswaResponseList;
//
//        }
//
//        @GetMapping("getAllWithSorting")
//        public List<SiswaResponse>getAllSiswaWithSorting(){
//        List<Siswa> siswaList = siswaService.getAllSiswaWithSorting();
//
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//            siswaList.stream().forEach(siswa -> {
//                siswaResponseList.add(new SiswaResponse(siswa));
//            });
//            return siswaResponseList;
//
//        }
//
//        @GetMapping("like/{firstName}")
//    public List<SiswaResponse> like(@PathVariable String firstName){
//        List<Siswa> siswaList = siswaService.like(firstName);
//
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//        siswaList.stream().forEach(siswa -> {
//            siswaResponseList.add(new SiswaResponse(siswa));
//        });
//
//        return siswaResponseList;
//
//        }
//
//        @GetMapping("startwith/{firstName}")
//         public List<SiswaResponse> startWith(@PathVariable String firstName){
//        List<Siswa> siswaList = siswaService.startsWith(firstName);
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//            siswaList.stream().forEach(siswa -> {
//                siswaResponseList.add(new SiswaResponse(siswa));
//            });
//
//            return siswaResponseList;
//
//        }
//
//        @DeleteMapping("deleteByFirstName/{firstName}")
//        public String deleteStudent (@PathVariable String firstName){
//            return siswaService.deleteSiswa(firstName) + "siswa(s) deleted";
//        }
//
//        @GetMapping("/by-city/{city}")
//        public List<SiswaResponse> getByCity(@PathVariable String city){
//        List<Siswa> siswaList = siswaService.getByCity(city);
//
//        List<SiswaResponse> siswaResponseList = new ArrayList<SiswaResponse>();
//
//        siswaList.stream().forEach(siswa -> {
//            siswaResponseList.add(new SiswaResponse(siswa));
//        });
//        return siswaResponseList;
//
//        }





}
