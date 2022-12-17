package com.example.rpggraphic;

import com.example.rpggraphic.rpg.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        HelloApplication.stage = stage;
        stage.setTitle("RPG_LITE_3000_EVOLVED");
        stage.setScene(scene);
        Game.play();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}