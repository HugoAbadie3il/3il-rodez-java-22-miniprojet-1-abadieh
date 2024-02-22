package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

import java.util.Random;

/**
 * Cette classe représente un générateur de carte aléatoire.
 * Elle hérite de la classe GenerateurCarte et attribue au hasard des valeurs pour les 3 valeurs de terrain.
 */
public class GenerateurAleatoire extends GenerateurCarte {
    public GenerateurAleatoire(long graine){
        super(graine);
    }

    /**
     * Génère un terrain aléatoire pour une position donnée.
     *
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     * @return Le terrain généré pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        BruitAleatoire bruit = new BruitAleatoire(this.getGraine(), 1.0);
        double bruitAltitude = bruit.bruit2D(-1.0, 1.0);
        double bruitHydrometrie = bruit.bruit2D(0.0,1.0);
        double bruitTemperature = bruit.bruit2D(0.0,1.0);

        return new Terrain(bruitAltitude, bruitHydrometrie, bruitTemperature);
    }


}
