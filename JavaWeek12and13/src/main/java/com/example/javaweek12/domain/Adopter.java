package com.example.javaweek12.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Adopter {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;
   @Column (name = "adopterName")
    private String adopterName;
    private long phoneNumber;
    private LocalDate birthDay;

    //------------------------relationship

@OneToMany(mappedBy = "adopter", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
@JsonIgnoreProperties("adopter")
private List<Pet> pets;


    // ---------------------- constructors


    public Adopter(String adopterName, long phoneNumber, LocalDate birthDay) {
        this.adopterName = adopterName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }

    public Adopter() {

    }

    // --------------------- getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
