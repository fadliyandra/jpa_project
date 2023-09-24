package com.example.demo.service;


import com.example.demo.entity.Siswa;
import com.example.demo.repository.SiswaRepository;
import com.example.demo.request.CreateSiswaRequest;
import com.example.demo.request.UpdateSiswaRequest;
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

    public Siswa createSiswa(CreateSiswaRequest createSiswaRequest){
        Siswa siswa = new Siswa(createSiswaRequest);

        siswa = siswaRepository.save(siswa);
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

       public Siswa getByFirstNameAndLAstName (String firstName, String lastName){

       }


}
