package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

/**
 * Cette classe représente un générateur de carte utilisant la méthode Perlin
 * pour générer un tableau de terrains en fonction d'une graine.
 */
public class GenerateurPerlin extends GenerateurCarte{

        /**
        * Constructeur du générateur de carte.
        *
        * @param graine La graine utilisée pour la génération de la carte.
        */
        public GenerateurPerlin(long graine) {
            super(graine);
        }

        @Override
        protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
            double x = (double) i / largeur;
            double y = (double) j / hauteur;

            BruitPerlin2D bruitPerlinHydro = new BruitPerlin2D(this.getGraine(), 1);
            BruitPerlin2D bruitPerlinAlt = new BruitPerlin2D(this.getGraine() * 2, 1);
            BruitPerlin2D bruitPerlinTemp = new BruitPerlin2D(this.getGraine() * 4, 1);

            double altitude = bruitPerlinAlt.bruit2D(x, y);
            double hydrometrie = bruitPerlinHydro.bruit2D(x, y);
            double temperature = bruitPerlinTemp.bruit2D(x, y);

            hydrometrie = (hydrometrie + 1) / 2;
            temperature = (temperature + 1) / 2;

            return new Terrain(hydrometrie, altitude, temperature);
        }
}
