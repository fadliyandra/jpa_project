package com.example.demo.service;


import com.example.demo.entity.Address;
import com.example.demo.entity.Siswa;
import com.example.demo.entity.Subject;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.SiswaRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.request.CreateSiswaRequest;
import com.example.demo.request.CreateSubjectRequest;
import com.example.demo.request.InQueryRequest;
import com.example.demo.request.UpdateSiswaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SiswaService {

    @Autowired
    SiswaRepository siswaRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public List<Siswa> getAllSiswa(){
       return siswaRepository.findAll();
    }



    public Siswa createSiswa(CreateSiswaRequest createSiswaRequest){  //deklarasi method menerima create siswa request, membuat object siswa berdasar data yang di terima
        Siswa siswa = new Siswa(createSiswaRequest);  //ocject siswa baru di buat mennggnakan constructor yang menerima crate siswa request

        Address address = new Address();  //object adddres baru di buat
        address.setStreet(createSiswaRequest.getStreet()); // data street di atur ke dalam address
        address.setCity(createSiswaRequest.getCity()); //data city di atur ke dalam object address

        address = addressRepository.save(address); // disimpan ke dalam repository, menghasilkan id unik

        siswa.setAddress(address); //di hubugkan object siswa yang telah di buat denag address yang telah di simpan
        siswa = siswaRepository.save(siswa); // obeject siswa  di simpan dalam repository

        List<Subject> subjectList = new ArrayList<Subject>();  //buat object array list berupa subject list

        if (createSiswaRequest.getSubjectsLearning() != null){

            for (CreateSubjectRequest a :  // variable yang di ulang
            createSiswaRequest.getSubjectsLearning()){
                Subject subject = new Subject();  //pembuatan object
                subject.setSubjectName(a.getSubjectName());  // mengulang mengisi
                subject.setMarksObtained(a.getMarksObtained()); // mengulang mengisi
                subject.setSiswa(siswa);

                subjectList.add(subject);

            }
            subjectRepository.saveAll(subjectList);  //menyimpan
        }
        siswa.setLearningSubjects(subjectList); //set learing subeject ke siswa

        return siswa; //kembalian

    }

       public Siswa updateSiswa (UpdateSiswaRequest updateSiswaRequest){ //method
       Siswa siswa =  siswaRepository.findById(updateSiswaRequest.getId()).get();  //update berdasarkan id

        if (updateSiswaRequest.getFirstName() != null &&  //tidak null tidak kosong
        !updateSiswaRequest.getFirstName().isEmpty()){
            siswa.setFirstName(updateSiswaRequest.getFirstName());  //repo siswa di set sesuai update siswa request.firstname
        }

        siswa = siswaRepository.save(siswa);  //siwa di simpan d update di repo
        return siswa; //megembalikan siswa
       }



       public String deleteSiswa(long id){
        siswaRepository.deleteById(id);
        return "Siswa has been delete sukses";
       }

       public String deleteSubject(long id){  //method dengan prameter id
        subjectRepository.deleteById(id); //untuk menghapus entitas dari basis data
        return "subject di delete"; //return kembalian
       }

       public List<Siswa> getByFirstName (String firstName){
        return siswaRepository.findByFirstName(firstName);
       }

       public Siswa getByFirstNameAndLastName(String firstName, String lastName){
           // return siswaRepository.findByLastNameAndFirstName(firstName, lastName);
           return siswaRepository.getByLastNameAndFirstName(lastName, firstName);

       }

       public  List<Siswa> getByFirstNameOrLastName (String firstName, String lastName) {
           return siswaRepository.findByFirstNameOrLastName(firstName, lastName);
       }

        public  List<Siswa> getByFirstNameIn (InQueryRequest inQueryRequest) {
            return siswaRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
        }

        public List<Siswa> getAllSiswaWithPagination(int pageNo, int pageSize){
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

            return siswaRepository.findAll(pageable).getContent();
        }


        public List<Siswa> getAllSiswaWithSorting(){
            Sort sort = Sort.by(Sort.Direction.ASC, "firstName");

            return siswaRepository.findAll(sort);
        }

        public List<Siswa> like(String firstName){

            return siswaRepository.findByFirstNameContains(firstName);
        }


        public List<Siswa> startsWith(String firstName){
        return siswaRepository.findByFirstNameStartsWith(firstName);

        }

        public Integer updateStudentWithJpql (Long id, String firstName){
            return siswaRepository.updateFirstName(id, firstName);

        }

        public Integer deleteSiswa (String firstName){
        return siswaRepository.deletebyFirstName(firstName);

        }

        public List<Siswa> getByCity(String city){
        return siswaRepository.getByAddressCity(city);

        }






}
