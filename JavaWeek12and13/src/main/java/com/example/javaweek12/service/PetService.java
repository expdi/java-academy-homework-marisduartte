package com.example.javaweek12.service;

import com.example.javaweek12.dao.PetRepo;
import com.example.javaweek12.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepo petRepo;

    public List<Pet> getAllPets() {return petRepo.findAll();}

    public List<Pet> findByPetName(String petName){
        return this.petRepo.findByPetName(petName);
    }

    List<Pet> findByIsAdopted (boolean isAdopted){ return this.petRepo.findByIsAdopted(isAdopted);};

    List<Pet> findByEstimatedBirthDayBetween(LocalDate start, LocalDate end){return this.petRepo.findByEstimatedBirthDayBetween(start, end);};

    //List<Pet> findByAnimalType(Pet.AnimalType animalType){return this.petRepo.findByAnimalType();};

    List<Pet> findByDateOfAdoptionAfter(LocalDate dateOfAdoption){return this.petRepo.findByDateOfAdoptionAfter(dateOfAdoption);};

    Optional<Pet> findById(Long petId){return this.petRepo.findById(petId);};

    public Pet addPet(Pet pet){ return petRepo.save(pet);}

    public boolean updatePet(Pet pet) {
        Pet petResult = this.petRepo.getReferenceById(pet.getId());

        if(petResult != null){
            petRepo.save(pet);
            return true;
        }
        return false;
    }

    public boolean deletePet(Long id) {
        Pet petResult = this.petRepo.getReferenceById(id);

        if(petResult != null){
            petRepo.delete(petResult);
            return true;
        }
        return false;
    }

    public Pet get(Long id){return petRepo.getReferenceById(id);}


}
