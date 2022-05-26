package com.example.lab4;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

    public class Kulka{
    private static final double R = 10;
    protected double ySpeed;
    protected double xSpeed;
    protected double yPos;
    protected double xPos;
    public Color color;

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed)
    {
        this.xPos=xPos;
        this.yPos=yPos;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
        color = Color.WHITESMOKE;
    }

    public Kulka(double xPos, double yPos, double xSpeed, double ySpeed, Color color)
    {
        this(xPos,yPos,xSpeed,ySpeed);
        this.color = color;
    }

    public void checkBoundaryCollision(double xLeft,double yTop,double xRight,double yBottom)
    {
        if((xPos-R<=xLeft) || ((xPos+R>=xRight))){
            xSpeed=-xSpeed;
        }
        if((yPos-R<=yTop) || ((yPos+R>=yBottom))){
            ySpeed=-ySpeed;
        }
    }
    public void draw(GraphicsContext gc)
    {
        gc.setFill(color);
        gc.fillOval(xPos-R,yPos-R,2*R,2*R);
    }
    public void update()
    {
        xPos+=xSpeed;
        yPos+=ySpeed;
    }
}