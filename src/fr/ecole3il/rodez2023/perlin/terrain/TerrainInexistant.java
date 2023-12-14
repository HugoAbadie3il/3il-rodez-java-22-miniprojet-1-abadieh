package fr.ecole3il.rodez2023.perlin.terrain;

public class TerrainInexistant extends ArrayIndexOutOfBoundsException{

    public TerrainInexistant(String message){
        super(message);
        System.err.println(message);
    }
}
