package com.isep.rpg;

import com.isep.rpg.enemies.Dragon;
import com.isep.rpg.enemies.Leprechauns;
import com.isep.rpg.enemies.Troll;

import java.util.*;

public class Game {
    private static List<Hero> heroes;
    private static List<Enemy> enemies = new ArrayList<>();
    private static int enemiesWave = 1;
    private  List<Consumable> items = new ArrayList<>();

    private int cptDeadEnemies = 0;



    public Game(){

    }

    public static List<Enemy> getEnemies(){
        return enemies;
    }

    public  List<Consumable> getItems(){
        return items;
    }

    /**
     * @brief : Méthode gérant la vie du jeu
     */
    public void playGame(){
        System.out.println("Bienvenue sur Mini RPG Lite 3000 !\n Choisissez le nombre de heros que vous voulez : ");
        int nbHeroes = collectnbHeroes();
        System.out.println("Choisissez les classes de vos " + nbHeroes + " heros parmi celles-ci :\n1.Hunter\n2.Mage\n3.Warrior\n4.Healer");
        initHeroes(nbHeroes);
        initEnemies(nbHeroes);
        initItems(nbHeroes);
        while(!isGameOver()){
            generatePlayTurn();
        }
        System.out.println("Malheureusement, tous les heros sont morts au combat\nDerniere vague : " + enemiesWave + "\nNombre d'ennemis vaincus : " + cptDeadEnemies);
    }


    /**
     * @brief : Récupère le nombre de héros à initialiser entré par l'utilisateur
     * @return le nombre de héros à initialiser
     */
    private int collectnbHeroes(){
        Scanner scanner = new Scanner(System.in);
        int nbHero = -1;
        boolean nbValid = true;
        do{
            nbValid = true;
            try{
                nbHero = scanner.nextInt();
                if(nbHero <= 0 || nbHero > 10){
                    nbValid = false;
                    throw new IllegalArgumentException();
                }
            }catch(IllegalArgumentException e){
                System.out.println("Ce nombre est invalide, re-essayez : ");
            }

        }while(!nbValid);

        return nbHero;
    }

    /**
     * @Brief : initialisation des héros
     * @param nbHeroes : Nombre de héros à initialiser
     */
    private void initHeroes(int nbHeroes){
        heroes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < nbHeroes; ++i){
            //  L'utilisateur peut entrer le numéro ou la classe
            switch(scanner.next()){
                case "Hunter", "1":
                    heroes.add(new Hunter());
                    break;
                case "Mage", "2":
                    heroes.add(new Mage());
                    items.add(new Potion());
                    break;
                case "Warrior", "3":
                    heroes.add(new Warrior());
                    break;
                case "Healer", "4":
                    heroes.add(new Healer());
                    items.add(new Potion());
                    break;
                default:
                    System.out.println("Cette option n'est pas valide, réessayez : ");
                    initHeroes(nbHeroes);
            }
        }
    }

    /**
     * @brief : Initialisation des ennemis
     * @param nbHeroes : Nombre de héros ayant été initialisés
     */
    public static void initEnemies(int nbHeroes){
        int nbEnemies = (int)Math.ceil(nbHeroes * 1.26);
        for(int i = 0; i < nbEnemies; ++i){
            Random rd = new Random();
            int choice = rd.nextInt(2);
            if(choice == 0){
                enemies.add(new Troll());
            }
            else if(choice == 1){
                enemies.add(new Leprechauns());
            }
        }
    }

    /**
     * @brief : Initialisation des Items
     * @param nbHeroes : Nombre de héros qui ont été initialisés
     */
    public void initItems(int nbHeroes){
        for(int i = 0; i < nbHeroes*2; i++){
            items.add(new Food());
        }
    }

    /**
     * @brief : Détermine si le jeu est fini ou non
     * @return true si le jeu est fini, false sinon
     */
    private static boolean isGameOver(){
        if(heroes.size() == 0 || enemies.size() == 0){
            return true;
        }
        return false;

    }

    /**
     * @brief : Récupération de l'input de l'utilisateur pour le choix entre attaquer et prendre une potion
     * @param cmbt : Combattant devant choisir de prendre une potion ou d'attaquer
     * @return false, si l'utilisateur choisi d'attaquer et true s'il prend une potion
     */
    private boolean attackOrPotion(Combatant cmbt){
        System.out.println("Le " + cmbt.getName() + " doit-il attaquer ou prendre une potion ?\n1 : Attack \n2: Potion");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.next()){
            case "ATTACK","Attack","attack","1":
                return false;

            case "POTION","Potion","potion","2":
                return true;
            default:
                System.out.println("Ce n'est pas une option");
                System.out.println("Veuillez saisir les bons parametres d entree");
                attackOrPotion(cmbt);
        }
        return false;
    }

    /**
     * @brief : Récupère l'input de l'utilisateur concernant le choix de la potion et applique son effet sur le héro passé en paramètre
     * @param h : le héro sur lequel l'effet de la potion va s'appliquer
     */
    private void chooseConsumable(Hero h){
        for(int i = 0; i < items.size(); ++i){
            System.out.println(i + ") " + items.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int numPotion = scanner.nextInt();
        if(numPotion >= 0 && numPotion < items.size()){
            items.get(numPotion).applyEffect(h);
            items.remove(numPotion);
        }
    }


    /**
     * @brief : Génère l'ordre d'attaque des combattants et les vagues d'ennemis
     */
    private void generatePlayTurn(){
        List<Combatant> players = new ArrayList<>();
        for(Hero h : heroes){
            players.add(h);
        }
        for(Enemy e : enemies){
            players.add(e);
        }
        // Faire un shuffle
        Collections.shuffle(players);
        fight(players);
        if(enemies.size() == 0){
            System.out.println("---------- Vague " + (enemiesWave + 1) + " ----------");
            enemiesWave++;
            if(enemiesWave%5 == 0 ){
                System.out.println("WARNING LE BOSS ARRIVE");
                enemies.add(new Dragon());
            }else{
                initEnemies(heroes.size());
            }
        }
    }

    /**
     * @brief : Gère l'attaque d'un combattant
     * @param c : le combattant attaquant
     */
    private void attack(Combatant c){
        Combatant cmbt;
        if(((Hero)c).isSpellCaster() && ((SpellCaster) c).isHealer()){
                cmbt = healerChoiceHero();
        }else{
            cmbt = enemyChoicePlayer(c);
        }
        c.attack(cmbt, c.getWpn().getDamage());
        if(cmbt.getHealthPoints() == 0){
            enemies.remove(cmbt);
            cptDeadEnemies++;
            System.out.println(cmbt.getName() + " est mort.");
            ((Hero) c).chooseLoot();
        }
    }


    /**
     * @brief : Gère le choix du combattant
     * @param players : Liste des combattants ayant été mélangés
     */
    private void fight(List<Combatant> players){
        for(Combatant p : players){
            if(p.isHero()){
                if(p.getHealthPoints() > 0 && enemies.size() > 0){
                    if(attackOrPotion(p) && items.size() != 0){
                        // Boire une potion
                        chooseConsumable((Hero)p);
                    } else{
                        // Attaquer
                        if(items.size() == 0){
                            System.out.println("Il n'y a plus de potion");
                        }
                        attack(p);
                    }
                }
            }
            else{
                if(p.getHealthPoints() > 0 && heroes.size() > 0){
                    Combatant cmbt = enemyChoiceComputer();
                    p.attack(cmbt, p.getWpn().getDamage());

                    if(cmbt.getHealthPoints() == 0){
                        heroes.remove(cmbt);
                        System.out.println("Votre hero " + cmbt.getName() + " est mort, paix a son ame...");
                    }
                }
            }
        }
    }

    /**
     * @brief : Choix de l'utilisateur de l'ennemi à attaquer
     * @param hero : Le Hero qui va attaquer un ennemi
     * @return l'ennemi sélectionné
     */
    private Combatant enemyChoicePlayer(Combatant hero){
        System.out.println("C'est le tour de " + hero.getName() + ". Qui voulez vous attaquer ?");
        int cpt = 0;
        for(Combatant e : enemies){
            System.out.println(cpt + ") " + e.getName() + " avec " + e.getHealthPoints() + " points de vie.");
            cpt++;
        }
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int num;
        do{
            num = scanner.nextInt();
            if(num > enemies.size() - 1 || num < 0){
                valid = false;
                System.out.println("La valeur entree ne corrrespond pas a un numero d'ennemi");
            }
            else {
                valid = true;
            }
        }while(!valid);
        return enemies.get(num);
    }

    /**
     * @brief : Choix du Healer du Hero à soigner
     * @return le Hero qui sera soigné
     */
    private Combatant healerChoiceHero(){
        System.out.println("C'est le tour du Healer. Qui voulez-vous soigner ?");
        int cpt = 0;
        for(Hero h : heroes){
            System.out.println(cpt + ") " + h.getName() + " avec " + h.getHealthPoints() + " points de vie.");
            cpt++;
        }
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int num;
        do{
            num = scanner.nextInt();
            if(num > heroes.size() - 1 || num < 0){
                valid = false;
                System.out.println("La valeur entree ne corrrespond pas a un numero de hero");
            }
            else {
                valid = true;
            }
        }while(!valid);
        return heroes.get(num);
    }

    /**
     * @brief Choix de l'ennemi du Hero à attaquer
     * @return Le Hero qui sera attaqué par l'ennemi
     */
    private static Combatant enemyChoiceComputer(){
        Random rd = new Random();
        return heroes.get(rd.nextInt(heroes.size()));
    }

}
