package com.example.rpggraphic.rpg;

import com.example.rpggraphic.rpg.enemies.Troll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private static Game context;
    private int nbHeroes;
    private List<Combatant> heroes = new ArrayList<>();
    private List<Combatant> enemies = new ArrayList<>();

    private Game(){

    }

    public static Game getContext(){
        return context;
    }

    public static void play(){
        Game.context = new Game();
    }

    public void setNbHeroes(int nb){
        nbHeroes = nb;
    }

    public int getNbHeroes(){
        return nbHeroes;
    }

    public List<Combatant> getHeroes(){
        return heroes;
    }

    public List<Combatant> getEnemies(){
        return enemies;
    }


    public boolean isGameOver(){
        if(heroes.size() == 0){
            return true;
        }
        return false;
    }


    public void createEnemies(){
        int nbEnemies = (int)Math.ceil(nbHeroes * 1.26);
        for(int i = 0; i < nbEnemies; ++i){
            enemies.add(new Troll());
        }
    }

    public void initialisation(int w, int m, int hunt, int heal){
        for(int i = 0; i < w; ++i){
            heroes.add(new Warrior());
        }
        for(int i = 0; i < m; ++i){
            heroes.add(new Mage());
        }
        for(int i = 0; i < hunt; ++i){
            heroes.add(new Hunter());
        }
        for(int i = 0; i < heal; ++i){
            heroes.add(new Healer());
        }
        // Création des ennemis
        createEnemies();
    }

    public List<Combatant> playTurn(){
        List<Combatant> players = new ArrayList<>();
        for(Combatant h : heroes){
            players.add(h);
        }
        for(Combatant e : enemies){
            players.add(e);
        }
        // Faire un shuffle
        Collections.shuffle(players);
        return players;
    }


    public int attack(Combatant attacker, Combatant victim){
        int damage = attacker.getWpn().getDamage();
        attacker.attack(victim, attacker.getWpn().getDamage());
        if(victim.getHealthPoints() == 0){
            if(victim.isHero()){
                heroes.remove(victim);
            }else{
                enemies.remove(victim);
            }
        }
        return damage;
    }
}
