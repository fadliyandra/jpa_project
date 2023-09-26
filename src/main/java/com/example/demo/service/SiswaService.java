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



    public Siswa createSiswa(CreateSiswaRequest createSiswaRequest){
        Siswa siswa = new Siswa(createSiswaRequest);

        Address address = new Address();
        address.setStreet(createSiswaRequest.getStreet());
        address.setCity(createSiswaRequest.getCity());

        address = addressRepository.save(address);

        siswa.setAddress(address);
        siswa = siswaRepository.save(siswa);

        List<Subject> subjectList = new ArrayList<Subject>();

        if (createSiswaRequest.getSubjectsLearning() != null){

            for (CreateSubjectRequest createSubjectRequest :
            createSiswaRequest.getSubjectsLearning()){
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setSiswa(siswa);

                subjectList.add(subject);

            }
            subjectRepository.saveAll(subjectList);
        }
        siswa.setLearningSubjects(subjectList);

        return siswa;

    }

       public Siswa updateSiswa (UpdateSiswaRequest updateSiswaRequest){
       Siswa siswa =  siswaRepository.findById(updateSiswaRequest.getId()).get();

        if (updateSiswaRequest.getFirstName() != null &&
        !updateSiswaRequest.getFirstName().isEmpty()){
            siswa.setFirstName(updateSiswaRequest.getFirstName());
        }

        siswa = siswaRepository.save(siswa);
        return siswa;
       }

       public String deleteSiswa(long id){
        siswaRepository.deleteById(id);
        return "Siswa has been delete sukses";
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
