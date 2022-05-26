package com.example.lab4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.EventListener;

import static javafx.scene.paint.Color.WHITESMOKE;

public class HelloApplication extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private static final double MARGIN = 50;
    private static final double ARENAWIDTH = WIDTH - 2*MARGIN;
    private static final double ARENAHEIGHT = HEIGHT - 2*MARGIN;
    private static final double ARENAX1 = MARGIN;
    private static final double ARENAY1 = MARGIN;
    private static final double ARENAX2 = ARENAX1 + ARENAWIDTH;
    private static final double ARENAY2 = ARENAY1 + ARENAHEIGHT;
    private static final double R=10;
    private double x = ARENAX1+ARENAWIDTH/2;
    private double y = ARENAY1+ARENAHEIGHT/2;
    private double vx = 5;
    private double vy = 2;

    private void run(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1,ARENAY1,ARENAWIDTH,ARENAHEIGHT);

        if((x<=ARENAX1) || ((x>=ARENAX2))) vx = -vx;
        if((y<=ARENAY1) || ((y>=ARENAY2))) vy = -vy;

        x +=vx;
        y +=vy;

        gc.setFill(Color.WHITESMOKE);
        gc.fillOval(x,y,2*R,2*R);
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline t = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        t.setCycleCount(Timeline.INDEFINITE);

        stage.setTitle("Kulki!");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();

        t.play();
    }



    public static void main(String[] args) {
        launch();
    }
}

