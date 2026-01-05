package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // define container
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve a bean for Car
        Car car = container.getBean("carBean", Car.class);
        car.storevehicle();

        // retrieve a bean for Plane
        Plane plane = container.getBean("planeBean", Plane.class);
        plane.storevehicle();
    }
}