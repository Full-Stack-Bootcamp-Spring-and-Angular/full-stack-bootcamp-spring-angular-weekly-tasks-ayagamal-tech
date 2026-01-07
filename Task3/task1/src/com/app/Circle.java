package com.app;

public class Circle implements Shape {

    private final Draw2D draw2D;

    // Constructor injection into Circle
    public Circle(Draw2D draw2D){
        this.draw2D = draw2D;
    }

    @Override
    public void draw2D() {
        draw2D.draw2D("Circle");
    }

}