package com.exemple.monprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.monprojet.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}