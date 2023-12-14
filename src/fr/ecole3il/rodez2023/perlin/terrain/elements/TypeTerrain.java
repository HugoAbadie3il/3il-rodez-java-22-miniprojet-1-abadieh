package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

public enum TypeTerrain {
    COLLINES,
    DESERT,
    FORET_CONIFERES,
    FORET_FEUILLUS,
    MARAIS,
    MONTAGNE,
    OCEAN,
    PLAINE,
    TOUNDRA;

    private String nomFichier;

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        switch (this)
        {
            case COLLINES -> res.append("collines");
            case DESERT -> res.append("desert");
            case FORET_CONIFERES -> res.append("forêt de conifères");
            case FORET_FEUILLUS -> res.append("forêt de feuillus");
            case MARAIS -> res.append("marais");
            case MONTAGNE -> res.append("montagne");
            case OCEAN -> res.append("océan");
            case PLAINE -> res.append("plaine");
            case TOUNDRA -> res.append("toundra");
        }
        return res.toString();
    }

    public BufferedImage getImage(){
        return Utils.chargerTuile(nomFichier);
    }

}
