package com.app;

public class Circle implements Shape {

    @Override
    public void getArea(double redis) {
        System.out.println("the area of the circle = "+ Math.PI * Math.pow(redis,2));
    }

}