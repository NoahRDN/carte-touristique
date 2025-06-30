package com.exemple.monprojet.service;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.monprojet.dto.LieuDto;
import com.exemple.monprojet.model.Lieu;
import com.exemple.monprojet.repository.LieuRepository;

@Service
public class LieuService {
    @Autowired
    private LieuRepository lieuRepository;

    private GeometryFactory geometryFactory = new GeometryFactory();

    public void importFromJson(List<LieuDto> lieuxDto) {
        for (LieuDto dto : lieuxDto) {
            Lieu lieu = new Lieu();
            lieu.setNom(dto.getNom());
            lieu.setDescription(dto.getDescription());
            lieu.setType(dto.getType());
            lieu.setPays(dto.getPays());
            lieu.setVille(dto.getVille());

            // Créer un Point à partir des coordonnées
            Point point = geometryFactory.createPoint(new Coordinate(dto.getLongitude(), dto.getLatitude()));
            lieu.setGeom(point);

            lieu.setImageUrl(dto.getImageUrl());
            lieu.setSiteWeb(dto.getSiteWeb());

            lieuRepository.save(lieu);
        }
    }

    public List<LieuDto> getLieuxFiltres(String pays, String ville, String type) {
    return lieuRepository.findAll().stream()
            .filter(lieu -> pays == null || pays.isEmpty() || lieu.getPays().equalsIgnoreCase(pays))
            .filter(lieu -> ville == null || ville.isEmpty() || lieu.getVille().equalsIgnoreCase(ville))
            .filter(lieu -> type == null || type.isEmpty() || lieu.getType().equalsIgnoreCase(type))
            .map(this::convertToDto)
            .toList(); 
    }

    private LieuDto convertToDto(Lieu lieu) {
        LieuDto dto = new LieuDto();
        dto.setNom(lieu.getNom());
        dto.setDescription(lieu.getDescription());
        dto.setType(lieu.getType());
        dto.setPays(lieu.getPays());
        dto.setVille(lieu.getVille());
        dto.setLatitude(lieu.getGeom().getY()); 
        dto.setLongitude(lieu.getGeom().getX()); 
        dto.setImageUrl(lieu.getImageUrl());
        dto.setSiteWeb(lieu.getSiteWeb());
        return dto;
    }
}
