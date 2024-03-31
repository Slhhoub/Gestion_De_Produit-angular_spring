package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FectureRepository extends JpaRepository<facture,Integer> {
}
