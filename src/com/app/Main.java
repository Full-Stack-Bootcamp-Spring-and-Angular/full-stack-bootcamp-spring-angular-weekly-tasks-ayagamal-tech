package com.app;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter: ");
        double value = input.nextDouble();

        // define container
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve a bean for com.com.app.Circle class
        Shape circle = container.getBean("circle", Shape.class);
        circle.getArea(value);

        // retrieve a bean for com.com.app.Circle class
        com.app.Shape square = container.getBean("square", com.app.Shape.class);
        square.getArea(value);

    }
}