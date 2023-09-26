package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/siswa/")
public class AddressController {


    Logger logger = LoggerFactory.getLogger(AddressController.class);

    @GetMapping("address")
    public String getAddress(){


        logger.error("Inside Error");
        logger.warn("Inside Waring");
        logger.info("Inside Info");
        logger.debug("inside Debug");
        logger.trace("Inside Trace");


        return "ini alamat siswa";
    }
}
