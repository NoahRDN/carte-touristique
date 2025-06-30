package com.exemple.monprojet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pays") 
public class Country {

    @Id
    private String code;
    private String nom;
    private String drapeauUrl;

    // Getters and setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDrapeauUrl() { return drapeauUrl; }
    public void setDrapeauUrl(String drapeauUrl) { this.drapeauUrl = drapeauUrl; }
}
