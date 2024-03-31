package com.gestionProduit.backEnd.service.produit;

import com.gestionProduit.backEnd.Entity.Produit;
import com.gestionProduit.backEnd.Entity.client;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    List<Produit> getAllProduit();
    Optional<Produit> getProduitById(Integer id);
    Produit createProduit(Produit produit);
    Produit updateProduit(Produit produit,Integer id);
    void removeProduitById(Integer id);
}
