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
import java.util.Random;

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
    private static final int LICZBAKULEK = 10;
    private double[] x = new double[LICZBAKULEK];
    private double[] y = new double[LICZBAKULEK];
    private double[] vx = new double[LICZBAKULEK];
    private double[] vy = new double[LICZBAKULEK];

    private void intKula() {
        Random lott = new Random();
        for (int i = 0; 1 < LICZBAKULEK; i++) {
            x[i] = lott.nextDouble() * ARENAWIDTH + ARENAX1;
            y[i] = lott.nextDouble() * ARENAHEIGHT + ARENAY1;
            vx[i] = 5 + lott.nextDouble() * 20;
            vy[i] = 5 + lott.nextDouble() * 20;
        }
    }

    private void run(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.fillRect(ARENAX1,ARENAY1,ARENAWIDTH,ARENAHEIGHT);

        for (int i=0;i<LICZBAKULEK;i++){
        if((x[i]<=ARENAX1+R) || ((x[i]>=ARENAX2-R))) vx[i] = -vx[i];
        if((y[i]<=ARENAY1+R) || ((y[i]>=ARENAY2-R))) vy[i] = -vy[i];
        }
        for (int i=0;i<LICZBAKULEK;i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }
        for (int i=0;i<LICZBAKULEK;i++) {
        gc.setFill(Color.WHITESMOKE);
        gc.fillOval(x[i]-R,y[i]-R,2*R,2*R);
        }}

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

