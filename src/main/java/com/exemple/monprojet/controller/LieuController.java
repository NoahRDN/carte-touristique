package com.exemple.monprojet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.monprojet.dto.LieuDto;
import com.exemple.monprojet.service.LieuService;

@RestController
@RequestMapping("/api")
public class LieuController {
    @Autowired
    private LieuService lieuService;

    @GetMapping("/lieux")
    public List<LieuDto> getLieux(
        @RequestParam(required = false) String pays,
        @RequestParam(required = false) String ville,
        @RequestParam(required = false) String type
    ) {
        return lieuService.getLieuxFiltres(pays, ville, type);
    }
}
