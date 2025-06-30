package com.exemple.monprojet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "villes") 
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "pays_code")
    private Country pays;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Country getPays() { return pays; }
    public void setPays(Country pays) { this.pays = pays; }
}
