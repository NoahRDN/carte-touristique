\c mabase
DROP DATABASE cartetouristique;

CREATE DATABASE cartetouristique;
\c cartetouristique 

CREATE EXTENSION postgis;

CREATE TABLE lieux (
  id SERIAL PRIMARY KEY,
  nom TEXT NOT NULL,
  description TEXT,
  type TEXT CHECK (type IN ('tourisme', 'hebergement', 'restaurant', 'transport')),
  pays TEXT NOT NULL,
  ville TEXT NOT NULL,
  geom GEOMETRY(Point, 4326),
  image_url TEXT,
  site_web TEXT
);

CREATE TABLE pays (
  code TEXT PRIMARY KEY,
  nom TEXT,
  drapeau_url TEXT
);

CREATE TABLE villes (
  id SERIAL PRIMARY KEY,
  nom TEXT,
  pays_code TEXT REFERENCES pays(code)
);

