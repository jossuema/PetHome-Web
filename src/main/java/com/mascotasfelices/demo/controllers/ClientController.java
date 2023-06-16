package com.mascotasfelices.demo.controllers;

import com.mascotasfelices.demo.dao.IClientDAO;
import com.mascotasfelices.demo.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private IClientDAO clientController;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id){
        Optional<Client> cl = clientController.findById(id);
        if(cl.isPresent()) {
            return ResponseEntity.ok(cl.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Client>> getAllClients(){
        var clients = clientController.findAll();
        return ResponseEntity.ok(clients);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Client> createClient(@RequestBody Client cl){
        Client cll = clientController.save(cl);
        return ResponseEntity.status(HttpStatus.CREATED).body(cll);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id){
        clientController.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
