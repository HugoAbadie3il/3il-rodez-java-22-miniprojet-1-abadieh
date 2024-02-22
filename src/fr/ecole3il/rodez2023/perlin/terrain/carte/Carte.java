package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Scanner;

public class Carte {
    private String nom;
    private final int largeur;
    private final int hauteur;
    private Terrain[][] terrains;

    public Carte(int largeur, int hauteur, String nom, GenerateurCarte generateurCarte)
    {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.nom = nom;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur);
    }

    /**
     * Constructeur de la classe Carte.
     * @param donneesCarte Les données de la carte.
     */
    public Carte(String donneesCarte){
        Scanner s = new Scanner(donneesCarte);
        this.nom = s.nextLine();
        this.largeur = s.nextInt();
        this.hauteur = s.nextInt();

        s.nextLine();
        this.terrains = new Terrain[largeur][hauteur];
        double hydrometrie, altitude, temperature;

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                altitude = Double.parseDouble(s.next());
                hydrometrie = Double.parseDouble(s.next());
                temperature = Double.parseDouble(s.next());
                terrains[x][y] = new Terrain(altitude, hydrometrie, temperature);
            }
        }
        s.close();
    }

    public String getNom() {
        return nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y) throws TerrainInexistant
    {
        if (x < 0 || x >= largeur)
            throw new TerrainInexistant("x doit être compris entre 0 et " + largeur);
        if (y < 0 || y >= hauteur)
            throw new TerrainInexistant("y doit être compris entre 0 et " + hauteur);
        return terrains[x][y];
    }
}
