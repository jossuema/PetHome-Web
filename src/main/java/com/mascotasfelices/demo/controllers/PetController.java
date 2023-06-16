package com.mascotasfelices.demo.controllers;


import com.mascotasfelices.demo.dao.IPetDAO;
import com.mascotasfelices.demo.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pets")
public class PetController {
    @Autowired
    private IPetDAO petController;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable long id){
        Optional<Pet> cl = petController.findById(id);
        if(cl.isPresent()) {
            return ResponseEntity.ok(cl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Pet>> getAllPets(){
        var clients = petController.findAll();
        return ResponseEntity.ok(clients);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Pet> createClient(@RequestBody Pet pt){
        Pet ptt = petController.save(pt);
        return ResponseEntity.status(HttpStatus.CREATED).body(ptt);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable long id){
        petController.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
