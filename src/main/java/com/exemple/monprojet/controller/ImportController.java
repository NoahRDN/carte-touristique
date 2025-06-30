package com.exemple.monprojet.controller;

import com.exemple.monprojet.dto.LieuDto;
import com.exemple.monprojet.service.LieuService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImportController {

    @Autowired
    private LieuService lieuService;

    @PostMapping("/import-lieux")
    public String importLieux() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("data/zone_touristique_analamanga.geojson");

            JsonNode root = mapper.readTree(file);
            JsonNode features = root.get("features");

            String nomGlobal = root.path("name").asText("").toLowerCase();
            String typeGlobal = mapNameToType(nomGlobal);

            if (typeGlobal == null) {
                return "❌ Type inconnu à partir du nom global : \"" + nomGlobal + "\". Aucun lieu importé.";
            }

            List<LieuDto> lieux = new ArrayList<>();
            int ignorés = 0;

            for (JsonNode feature : features) {
                JsonNode props = feature.get("properties");
                JsonNode geometry = feature.get("geometry");
                JsonNode coords = geometry.get("coordinates");

                if (props == null || coords == null || coords.size() < 2) continue;

                LieuDto dto = new LieuDto();
                dto.setNom(props.path("name").asText("Unknown"));
                dto.setDescription(props.path("description").asText("No description"));
                dto.setType(typeGlobal);  // type global
                dto.setPays("Madagascar");
                dto.setVille(props.path("addr:city").asText("Unknown City"));
                dto.setImageUrl("");
                dto.setSiteWeb(props.path("website").asText(""));

                dto.setLongitude(coords.get(0).asDouble());
                dto.setLatitude(coords.get(1).asDouble());

                lieux.add(dto);
            }

            lieuService.importFromJson(lieux);
            return "✅ Import réussi de " + lieux.size() + " lieux (type : " + typeGlobal + ")";
        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Erreur à l'import : " + e.getMessage();
        }
    }

    // Déduction du type à partir du nom global du fichier
    private String mapNameToType(String name) {
        if (name.contains("touristique") || name.contains("attraction") || name.contains("site")) {
            return "tourisme";
        }
        if (name.contains("hotel") || name.contains("hébergement") || name.contains("guest") || name.contains("lodge")) {
            return "hebergement";
        }
        if (name.contains("restaurant") || name.contains("café") || name.contains("cafe") || name.contains("food")) {
            return "restaurant";
        }
        if (name.contains("transport") || name.contains("gare") || name.contains("station") || name.contains("aéroport")) {
            return "transport";
        }
        return null;
    }
}

