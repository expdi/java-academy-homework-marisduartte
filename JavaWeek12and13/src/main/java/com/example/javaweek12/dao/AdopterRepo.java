package com.example.javaweek12.dao;

import com.example.javaweek12.domain.Adopter;
import com.example.javaweek12.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdopterRepo extends JpaRepository<Adopter, Long> {

    List<Adopter> findByAdopterName(String adopterName);

    List<Adopter> findByBirthDayAfter(LocalDate birthDay);

    List<Adopter> findById(long id);


}
