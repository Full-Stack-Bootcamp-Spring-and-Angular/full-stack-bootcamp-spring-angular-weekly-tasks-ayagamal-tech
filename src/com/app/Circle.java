package com.app;

public class Circle implements Shape {

    @Override
    public void getArea(double radius) {
        System.out.println(String.format("the area of the circle = %s", Math.PI * Math.pow(radius,2)));
    }

}
