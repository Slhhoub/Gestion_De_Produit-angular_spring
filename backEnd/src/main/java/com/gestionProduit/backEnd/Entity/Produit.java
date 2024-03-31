package com.gestionProduit.backEnd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Produit")
public class Produit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Produit;
    private String type;
    @Column(unique = true)
    private String reference;
    private String description;
    private String prix;



}
