package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

/**
 * Cette classe représente un générateur de carte utilisant la méthode Perlin
 * pour générer un tableau de terrains en fonction d'une graine.
 */
public class GenerateurPerlin extends GenerateurCarte{

    private BruitPerlin2D bruitPerlinHydro;
    private BruitPerlin2D bruitPerlinAlt;
    private BruitPerlin2D bruitPerlinTemp;
        /**
        * Constructeur du générateur de carte.
        *
        * @param graine La graine utilisée pour la génération de la carte.
        */
        public GenerateurPerlin(long graine) {
            super(graine);
            this.bruitPerlinHydro = new BruitPerlin2D(this.getGraine(), 1);
            this.bruitPerlinAlt = new BruitPerlin2D(this.getGraine() * 2, 1);
            this.bruitPerlinTemp = new BruitPerlin2D(this.getGraine() * 4, 1);
        }

        @Override
        protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
            double x = (double) i / (double) largeur;
            double y = (double) j / (double) hauteur;

            double altitude = bruitPerlinAlt.bruit2D(x, y);
            double hydrometrie = bruitPerlinHydro.bruit2D(x, y);
            double temperature = bruitPerlinTemp.bruit2D(x, y);

            return new Terrain(altitude, hydrometrie, temperature);
        }
}
