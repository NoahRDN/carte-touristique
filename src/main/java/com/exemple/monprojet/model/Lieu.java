package com.exemple.monprojet.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "lieux")
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String description;

    @Column(nullable = false)
    private String type; // 'tourisme', 'hebergement', 'restaurant', 'transport'

    @Column(nullable = false)
    private String pays;

    @Column(nullable = false)
    private String ville;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point geom;

    private String imageUrl;

    private String siteWeb;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNom() {
      return nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getPays() {
      return pays;
    }

    public void setPays(String pays) {
      this.pays = pays;
    }

    public String getVille() {
      return ville;
    }

    public void setVille(String ville) {
      this.ville = ville;
    }

    public Point getGeom() {
      return geom;
    }

    public void setGeom(Point geom) {
      this.geom = geom;
    }

    public String getImageUrl() {
      return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
    }

    public String getSiteWeb() {
      return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
      this.siteWeb = siteWeb;
    }

  
}
