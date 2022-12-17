package com.example.rpggraphic.Controllers;

import com.example.rpggraphic.HelloApplication;
import com.example.rpggraphic.rpg.Combatant;
import com.example.rpggraphic.rpg.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightController {

    @FXML
    private static List<Label> heroesLabels = new ArrayList<>();
    @FXML
    private static List<Label> enemiesLabels = new ArrayList<>();
    @FXML
    private static List<Button> buttonsList = new ArrayList<>();

    private static Label description = new Label();
    private static FlowPane root = new FlowPane();

    private static Combatant currentCombatant;
    private static List<Combatant> enemies;
    private static  List<Combatant> heroes;
    private static int indiceTabPlayers = 0;

    private static List<Combatant> allPlayers;

    private static void initializeHeroes(){
        heroes = Game.getContext().getHeroes();
        for(int i = 0; i < heroes.size(); ++i){
            Label l = new Label(heroes.get(i).getName() + i + "\n");
            heroesLabels.add(l);
            root.getChildren().add(heroesLabels.get(i));
            l.setTranslateX(0);
            l.setTranslateY(100);
            createIcons(heroes.get(i),0,100);
        }
    }

    public static void turnManager(){
        root.getChildren().remove(buttonsList);
        root.getChildren().remove(enemiesLabels);
        enemiesLabels.clear();
        root.getChildren().remove(heroesLabels);
        heroesLabels.clear();
        root.getChildren().clear();

        if(Game.getContext().isGameOver()){
            gameOver();
        }
        else{
            root.getChildren().add(description);
            description.setTranslateX(400);
            if(indiceTabPlayers >= allPlayers.size()){
                heroes = Game.getContext().getHeroes();
                enemies = Game.getContext().getEnemies();
                allPlayers = Game.getContext().playTurn();
                indiceTabPlayers = 0;
            }
            Combatant cmbt = allPlayers.get(indiceTabPlayers);
            System.out.println(cmbt.getName());
            currentCombatant = cmbt;
            if(cmbt.isHero()){
                heroTurn(cmbt);
            }
            else{
                enemyTurn(cmbt);
            }
        }
    }

    private static void enemyTurn(Combatant cmbt) {
        enemies = Game.getContext().getEnemies();

        // Mettre les labels
        for(int i = 0; i < enemies.size(); ++i){
            Label l = new Label(enemies.get(i).getName() + " " + i + "\n");
            enemiesLabels.add(l);
            root.getChildren().add(l);
            l.setTranslateX(0);
            l.setTranslateY(120);
            createIcons(enemies.get(i), 0, 120);
        }
        //Choix de la victime au hasard
        Random rd = new Random();
        Combatant victim = heroes.get(rd.nextInt(heroes.size()));
        int dmg = Game.getContext().attack(currentCombatant, victim);
        description.setText(cmbt.getName() + " a inflige "+ dmg + " a " + victim.getName() + "\n");
        // Bouton next
        addButtonNext();
    }

    private static void heroTurn(Combatant cmbt) {
        heroes = Game.getContext().getHeroes();
        description.setText("C'est au tour de " + cmbt.getName() + " !\n");
        initializeHeroes();
        enemies = Game.getContext().getEnemies();
        if(enemies.size() == 0){
            Game.getContext().createEnemies();
        }
        for(int i = 0; i < enemies.size(); ++i){
            Label l = new Label(enemies.get(i).getName() + " " + i + "\n");
            enemiesLabels.add(l);
            root.getChildren().add(l);
            l.setTranslateX(0);
            l.setTranslateY(100);

            Button b = new Button("Attack " + enemies.get(i).getName() + " " + i);
            buttonsList.add(b);
            root.getChildren().add(b);
            b.setTranslateX(0);
            b.setTranslateY(120);
            initalizeAttackButtons();
            createIcons(enemies.get(i), 0, 120);
        }
    }

    private static void createIcons(Combatant c, int x, int y ){
        Image image = new Image(String.valueOf(HelloApplication.class.getResource("icons/" + c.getImagePath())), 50,50 ,false,true);
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
    }

    private static void initalizeAttackButtons() {
        for(Button b : buttonsList){
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    for(int i = 0; i < enemies.size(); ++i){
                        if(b.getText().equals("Attack " + enemies.get(i).getName()+ " " + i)){
                            description.setText(currentCombatant.getName() + " a inflige " + currentCombatant.getWpn().getDamage() + " a " + enemies.get(i).getName() + "\n");
                            Game.getContext().attack(currentCombatant, enemies.get(i));
                            // Création du Next
                            addButtonNext();
                        }
                    }
                }
            });
        }
    }


    private static void addButtonNext(){
        Button next = new Button("Next");
        //buttonsList.add(next);
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                indiceTabPlayers++;
                root.getChildren().remove(next);
                root.getChildren().remove(heroesLabels);
                heroesLabels.clear();
                root.getChildren().remove(enemiesLabels);
                enemiesLabels.clear();
                turnManager();
            }
        });
        root.getChildren().add(next);
        next.setTranslateX(0);
        next.setTranslateY(300);
    }



    public static void fight(){
        root.setPadding(new Insets(10));
        heroes = Game.getContext().getHeroes();
        enemies = Game.getContext().getEnemies();

        allPlayers = Game.getContext().playTurn();

        turnManager();

        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(HelloApplication.class.getResource("fight.css").toExternalForm());
        HelloApplication.stage.setTitle("Fight !");
        HelloApplication.stage.setScene(scene);
        HelloApplication.stage.show();
    }

    private static void gameOver(){
        root.getChildren().clear();
        // Mage
        Image imageM = new Image(String.valueOf(HelloApplication.class.getResource("icons/mage.png")), 150,150 ,false,true);
        ImageView imageViewM = new ImageView(imageM);
        root.getChildren().add(imageViewM);
        imageViewM.setTranslateX(50);
        imageViewM.setTranslateY(50);
        //Hunter
        Image imageH = new Image(String.valueOf(HelloApplication.class.getResource("icons/hunter.png")), 150,150 ,false,true);
        ImageView imageViewH = new ImageView(imageH);
        root.getChildren().add(imageViewH);
        imageViewH.setTranslateX(50);
        imageViewH.setTranslateY(50);
        // Healer
        Image imageHeal = new Image(String.valueOf(HelloApplication.class.getResource("icons/healer.png")), 150,150 ,false,true);
        ImageView imageViewHeal = new ImageView(imageHeal);
        root.getChildren().add(imageViewHeal);
        imageViewHeal.setTranslateX(50);
        imageViewHeal.setTranslateY(50);
        //Warrior
        Image imageW = new Image(String.valueOf(HelloApplication.class.getResource("icons/warrior.png")), 150,150 ,false,true);
        ImageView imageViewW = new ImageView(imageW);
        root.getChildren().add(imageViewW);
        imageViewW.setTranslateX(50);
        imageViewW.setTranslateY(50);
        description.setText("Tous les heros sont morts... Merci pour avoir bravement combattu les ennemis");
        root.getChildren().add(description);
        description.setTranslateX(50);
        description.setTranslateY(200);
    }
}