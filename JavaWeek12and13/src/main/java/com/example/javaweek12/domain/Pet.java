package com.example.javaweek12.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "petname")
    private String petName;
    @Enumerated(EnumType.STRING)
    @Column(name = "animaltype")
    private AnimalType animalType;

    private LocalDate dateOfAdoption;

    private LocalDate estimatedBirthDay;

    private boolean isAdopted;


    //-----------------------------enum

    public enum AnimalType {
        TURTLE, CAT, DOG
    }

    //----------------------------relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="adopter_id", nullable = true)
    @JsonIgnoreProperties("pets")
    private Adopter adopter;


    //----------------------------constructor

    public Pet() {
    }

    public Pet(String petName, AnimalType animalType, LocalDate dateOfAdoption, LocalDate estimatedBirthDay, boolean isAdopted) {
        this.petName = petName;
        this.animalType = animalType;
        this.dateOfAdoption = dateOfAdoption;
        this.estimatedBirthDay = estimatedBirthDay;
        this.isAdopted = isAdopted;
    }

    public Pet(String petName, AnimalType animalType, LocalDate estimatedBirthDay, boolean isAdopted) {
        this.petName = petName;
        this.animalType = animalType;
        this.estimatedBirthDay = estimatedBirthDay;
        this.isAdopted = isAdopted;
    }


    //--------------------------------getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public LocalDate getDateOfAdoption() {
        return dateOfAdoption;
    }

    public void setDateOfAdoption(LocalDate dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }

    public LocalDate getEstimatedBirthDay() {
        return estimatedBirthDay;
    }

    public void setEstimatedBirthDay(LocalDate estimatedBirthDay) {
        this.estimatedBirthDay = estimatedBirthDay;
    }
}

