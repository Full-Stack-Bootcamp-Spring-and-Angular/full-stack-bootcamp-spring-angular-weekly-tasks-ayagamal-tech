package com.app;

public class Square implements Shape {

    @Override
    public void getArea(double length) {
        System.out.println(String.format("the area of the Square = %s", Math.pow(length,2)));
    }
}
