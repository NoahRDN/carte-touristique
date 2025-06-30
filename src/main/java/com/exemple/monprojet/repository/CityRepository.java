package com.exemple.monprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.monprojet.model.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByPays_Code(String code);
}
