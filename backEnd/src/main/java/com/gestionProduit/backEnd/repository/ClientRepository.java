package com.gestionProduit.backEnd.repository;

import com.gestionProduit.backEnd.Entity.client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<client,Integer> {

}
