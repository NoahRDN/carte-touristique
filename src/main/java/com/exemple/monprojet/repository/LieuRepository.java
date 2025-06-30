package com.exemple.monprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.monprojet.model.Lieu;

import java.util.List;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Long> {
    List<Lieu> findByPays(String pays);
    List<Lieu> findByVille(String ville);
    List<Lieu> findByType(String type);
    // Ajoute d’autres méthodes selon besoin (ex: findByPaysAndVilleAndType)
}
