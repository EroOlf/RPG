package com.isep.utils.Exception;

public class IllegalNbHeroesException extends Exception{

    public IllegalNbHeroesException(int nb){
        if(nb <= 0){
            System.out.println("Il n'y a pas assez de héros");
        }
        else if(nb > 10){
            System.out.println("Il y a trop de héros, choisissez un nombre de héro(s) entre 0 et 10");
        }
    }
}
