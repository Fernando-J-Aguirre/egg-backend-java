package com.egg.orderManager.controller;

import com.egg.orderManager.model.dto.ClientDTO;
import com.egg.orderManager.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            clientService.createClient(clientDTO);
            return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        try{
           return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllClients() {
        try{
           return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            clientService.updateClient(id, clientDTO);
            return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
