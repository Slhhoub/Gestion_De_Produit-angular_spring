package com.gestionProduit.backEnd.controller;


import com.gestionProduit.backEnd.Entity.client;
import com.gestionProduit.backEnd.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/List")
    public ResponseEntity<List<client>>  getAllClinet(){
        return new ResponseEntity<>(clientService.getAllClinet(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>  getClientById(@PathVariable Integer id){
        Optional<client> optionalClient = clientService.getClinetById(id);
        if(optionalClient.isPresent()){
            return new ResponseEntity<>(optionalClient.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Client not found for id: "+id, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<client> createClient(@RequestBody client clientInfo){
        return  new ResponseEntity<>(clientService.createClient(clientInfo),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<client> updateClient(@RequestBody client clientInfo,@PathVariable Integer id){
        return  new ResponseEntity<>(clientService.updateClinet(clientInfo,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeClinetByid(@PathVariable Integer id){
         clientService.removeClinetById(id);
         return  ResponseEntity.noContent().build();
    }


}
