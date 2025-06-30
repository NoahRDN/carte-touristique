package com.exemple.monprojet.dto;

import com.exemple.monprojet.model.Lieu;

public class LieuDto {
    private Long id;
    private String nom;
    private String description;
    private String type;
    private String pays;
    private String ville;
    private double longitude;
    private double latitude;
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
    public double getLongitude() {
      return longitude;
    }
    public void setLongitude(double longitude) {
      this.longitude = longitude;
    }
    public double getLatitude() {
      return latitude;
    }
    public void setLatitude(double latitude) {
      this.latitude = latitude;
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
