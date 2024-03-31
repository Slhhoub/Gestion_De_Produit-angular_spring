package com.gestionProduit.backEnd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "facture")
public class facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Facture;
    private Date dateFacture;
    private double total;
    private String statut;
    private String methodePaiement;
    private Date datePaiement;
    @OneToOne
    private client client;
    @ManyToMany
    @JoinTable(name = "produit_facture",joinColumns = @JoinColumn(name = "id_Facture"),
            inverseJoinColumns = @JoinColumn(name = "id_Produit")
    )
    private List<Produit> produit;
}
