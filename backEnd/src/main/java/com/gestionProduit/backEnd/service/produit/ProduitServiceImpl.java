package com.gestionProduit.backEnd.service.produit;

import com.gestionProduit.backEnd.Entity.Produit;
import com.gestionProduit.backEnd.repository.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Optional<Produit> getProduitById(Integer id) {
        return produitRepository.findById(id);
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit, Integer id) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
        if(produitOptional.isPresent()){
            Produit existProduit = produitOptional.get();
            existProduit.setType(produit.getType());
            existProduit.setDescription(produit.getDescription());
            existProduit.setReference(produit.getReference());
            existProduit.setPrix(produit.getPrix());
           return produitRepository.save(existProduit);
        }else {
            throw  new EntityNotFoundException("Produit id not found : "+id);
        }
    }

    @Override
    public void removeProduitById(Integer id) {
        produitRepository.deleteById(id);
    }
}
