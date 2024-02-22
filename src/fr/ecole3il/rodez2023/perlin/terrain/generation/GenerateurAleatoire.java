package fr.ecole3il.rodez2023.perlin.terrain.generation;

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
        Random random = new Random(this.getGraine());
        return new Terrain(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }


}
