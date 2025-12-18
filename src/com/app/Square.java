package com.app;

public class Square implements Shape {

    @Override
    public void getArea(double length) {
        System.out.println("the area of the Square = " + Math.pow(length,2));
    }

}
