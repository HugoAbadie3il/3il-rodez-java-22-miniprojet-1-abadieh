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

    public Carte(String donneesCarte){
        Scanner s = new Scanner(donneesCarte);
        this.nom = s.nextLine();
        this.largeur = s.nextInt();
        this.hauteur = s.nextInt();

        //TO TEST IF I DON'T MISS THE FIRST DATA
        s.nextLine();
        int hydrometrie, altitude, temperature;
        int x = 0;
        int y = 0;

        while (s.hasNextLine())
        {
            // INSERT INTO TABLE
            altitude = s.nextInt();
            hydrometrie = s.nextInt();
            temperature = s.nextInt();
            if (x == largeur)
            {
                x = 0;
                y++;
            }
            terrains[x][y] = new Terrain(hydrometrie, altitude, temperature);
            s.nextLine();
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
