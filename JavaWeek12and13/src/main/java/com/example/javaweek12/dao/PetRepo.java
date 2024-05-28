package com.example.javaweek12.dao;

import com.example.javaweek12.domain.Adopter;
import com.example.javaweek12.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {

    HashMap<Long, Pet> pets = new HashMap<>();

    @Query(value = "SELECT p FROM Pet p WHERE p.isAdopted = false")
    List<Pet> findPetsNotAdopted();

    List<Pet> findByIsAdopted (boolean isAdopted);

    List<Pet> findByPetName(String petName);

    List<Pet> findByEstimatedBirthDayBetween(LocalDate start, LocalDate end);

    List<Pet> findByAnimalType(Pet.AnimalType animalType);

    List<Pet> findByDateOfAdoptionAfter(LocalDate dateOfAdoption);

    @Query(value = "SELECT p from Pet p LEFT JOIN fetch p.adopter where p.id = :id")
    Optional<Pet> findById(Long id);

//    public T add(T object);


//    public T get(int id);
    }




