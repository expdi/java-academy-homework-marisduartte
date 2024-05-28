package com.example.javaweek12.controllers;

import com.example.javaweek12.dao.PetRepo;
import com.example.javaweek12.domain.Pet;
import com.example.javaweek12.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private UriCreator uriCreator;

    @GetMapping
    public ResponseEntity<?> getAllPets() {
        List<Pet> pets = petService.getAllPets();
      return ResponseEntity.ok().body(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
     Pet pet = petService.get(id);
        return ResponseEntity.ok().body(pet);
    }

    @PostMapping
    public ResponseEntity<?> createPet(@RequestBody Pet pet) {
        Pet resultPet = this.petService.addPet(pet);
        URI newResource = uriCreator.getURI(resultPet.getId());
        return ResponseEntity.created(newResource).body(resultPet);
    }

    @PutMapping
    public ResponseEntity<?> updatePet(@RequestBody Pet pet) {
        boolean updated = this.petService.updatePet(pet);
        if (!updated) {
            return ResponseEntity.notFound().build();
        }
        URI newResource = uriCreator.getURI(pet.getId());
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") Long id) {
        try {
            this.petService.deletePet(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
