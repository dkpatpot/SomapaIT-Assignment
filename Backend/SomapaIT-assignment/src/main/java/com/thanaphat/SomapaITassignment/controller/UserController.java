package com.thanaphat.SomapaITassignment.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvValidationException;
import com.thanaphat.SomapaITassignment.model.UserModel;
import com.thanaphat.SomapaITassignment.service.UserService;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping("/readdatafromCSVfile")
    public List<UserModel> readdatafromCSVfile(){
        try {
            return userservice.readDataFromCSVFile();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace(); 
            return null; 
        }
    }

}
