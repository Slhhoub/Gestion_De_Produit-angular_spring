package com.gestionProduit.backEnd.controller;

import com.gestionProduit.backEnd.Entity.Produit;
import com.gestionProduit.backEnd.service.produit.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/list")
    public ResponseEntity<List<Produit>> getAllProduit(){
        return new ResponseEntity<>(produitService.getAllProduit(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getProduitById(@PathVariable Integer id){
        Optional<Produit> optionalProduit = produitService.getProduitById(id);
        if(optionalProduit.isPresent()){
            return new ResponseEntity<>(optionalProduit.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Produit not found for id: "+id, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit){
        return  new ResponseEntity<>(produitService.createProduit(produit),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@RequestBody Produit produit,@PathVariable Integer id){
        return  new ResponseEntity<>(produitService.updateProduit(produit,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduitByid(@PathVariable Integer id){
        produitService.removeProduitById(id);
        return  ResponseEntity.noContent().build();
    }

}
