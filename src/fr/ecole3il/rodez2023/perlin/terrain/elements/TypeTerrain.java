package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

public enum TypeTerrain {
    COLLINES,
    DESERT,
    FORET_CONIFÈRES,
    FORET_FEUILLUS,
    MARAIS,
    MONTAGNE,
    OCEAN,
    PLAINE,
    TOUNDRA;

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        switch (this)
        {
            case COLLINES -> res.append("collines");
            case DESERT -> res.append("desert");
            case FORET_CONIFÈRES -> res.append("forêt de conifères");
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
        StringBuilder filename = new StringBuilder();
        switch (this)
        {
            case COLLINES -> filename.append("hills");
            case DESERT -> filename.append("desert");
            case FORET_CONIFÈRES -> filename.append("coniferous_forest");
            case FORET_FEUILLUS -> filename.append("deciduous_forest");
            case MARAIS -> filename.append("marsh");
            case MONTAGNE -> filename.append("mountain");
            case OCEAN -> filename.append("ocean");
            case PLAINE -> filename.append("plain");
            case TOUNDRA -> filename.append("toundra");
        }
        filename.append(".png");
        return Utils.chargerTuile(filename.toString());
    }

}
