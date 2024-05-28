package com.example.javaweek12.service;

import com.example.javaweek12.dao.AdopterRepo;
import com.example.javaweek12.domain.Adopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {

 @Autowired
 private AdopterRepo adopterRepo;

 public List<Adopter> getAllAdopters() {return adopterRepo.findAll();}

 public Adopter insertAdopter (Adopter adopter) { return adopterRepo.save(adopter);}




    // create, update, delete, get

 }
