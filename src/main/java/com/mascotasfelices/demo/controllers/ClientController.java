package com.mascotasfelices.demo.controllers;

import com.mascotasfelices.demo.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {


    @GetMapping(value = "/{id}")
    public Client getClient(@PathVariable String id){
        Client cl = new Client();
        //Implementacion
        return cl;
    }


}
