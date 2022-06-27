package com.example.helicoptergame;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 700, 500);

        scene.getStylesheets().add("re.css");
        ImageView plane = createPlane(scene);
        ImageView c1=createC(scene);
        ImageView c2 =createL(scene);
        ImageView coin=createCoin(scene);
        root.getChildren().addAll(plane,c1,c2,coin);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = plane.getX();
            double y = plane.getY();

            switch (event.getCode()) {
                case LEFT -> plane.setX(x -10);
                case RIGHT -> plane.setX(x +10);
                case UP -> plane.setY(y - 10);
                case DOWN -> plane.setY(y + 10);

            }

            if (plane.getBoundsInParent().intersects(c1.getBoundsInParent())||plane.getBoundsInParent().intersects(c2.getBoundsInParent())) {

                System.out.println("game over");
                plane.setImage(new Image("fire.png"));

                scene.addEventFilter(KeyEvent.KEY_PRESSED, event1 -> {
                    double d = plane.getX();
                    double c = plane.getY();

                    switch (event.getCode()) {
                        case UP -> plane.setY(y - 0);
                        case DOWN -> plane.setY(y + 0);
                        case LEFT -> plane.setX(y -0);
                        case RIGHT -> plane.setX(y +0);

                    }
                });

            }
        });


        stage.setTitle("Helicopter game!");
        stage.setScene(scene);
        stage.show();
    }
    private ImageView createL(Scene scene)
    {
        ImageView lik = new ImageView(new Image("c3.png"));
        lik.setFitWidth(100);
        lik.setFitHeight(100);
        lik.setY(100);
        lik.setX(1800);
        TranslateTransition c = new TranslateTransition(Duration.millis(15000),lik);
        c.setByX(-2200);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return lik;
    }
    private ImageView createC(Scene scene){
        ImageView molatsi = new ImageView(new Image("c1.png"));
        molatsi.setFitWidth(100);
        molatsi.setFitHeight(100);
        molatsi.setY(300);
        molatsi.setX(1500);
        TranslateTransition c = new TranslateTransition(Duration.millis(10000),molatsi);
        c.setByX(-1800);
        c.setCycleCount(Integer.MAX_VALUE);
        c.play();

        return molatsi;
    }
    private ImageView createCoin(Scene scene){
        ImageView coin = new ImageView(new Image("dollar.png"));
        coin.setFitWidth(100);
        coin.setFitHeight(100);
        coin.setY(200);
        coin.setX(1500);
        TranslateTransition u = new TranslateTransition(Duration.millis(14000),coin);
        u.setByX(-1800);
        u.setCycleCount(Integer.MAX_VALUE);
        u.play();

        return coin;
    }
    private ImageView createPlane(Scene scene) {
        ImageView image = new ImageView(new Image("helicopter.png"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }

    public static void main(String[] args) {
        launch();
    }
}