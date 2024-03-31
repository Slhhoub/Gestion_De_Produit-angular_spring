package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
}
