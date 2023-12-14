package fr.ecole3il.rodez2023.perlin.terrain;

public class MauvaiseValeurException extends IllegalArgumentException{

    public MauvaiseValeurException(String message)
    {
        super(message);
        System.err.println(message);
    }
}
