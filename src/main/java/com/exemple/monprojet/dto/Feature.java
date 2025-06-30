package com.exemple.monprojet.dto;

public class Feature {
    public String type;
    public Geometry geometry;
    public Properties properties;

    public static class Geometry {
        public String type;
        public double[] coordinates;
    }

    public static class Properties {
        public String nom;
        public String description;
        public String type;
        public String pays;
        public String ville;
        public String image_url;
        public String site_web;
    }
}
