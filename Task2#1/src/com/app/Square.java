package com.app;

public class Square implements Shape {
    public Draw2D draw2D;
    public Draw3D draw3D;

    // Setter injection into Square
    public void setDraw2D(Draw2D draw2D){
        this.draw2D = draw2D;
    }

    @Override
    public void draw2D() {
        draw2D.draw2D("Square");
    }

    @Override
    public void draw3D() {
        draw3D.draw3D("Square");
    }
}
