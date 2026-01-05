package com.app;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // define container
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* CIRCLE */
        // Retrieve a bean for Circle class and draw the Circle
        Circle circle = (Circle) container.getBean("circle");

        // Use bean for Circle
        circle.draw2D();

        /* SQUARE */
        // Retrieve a bean for Square class and draw the Square
        Square square = (Square) container.getBean("square2D", Square.class);

        // Use bean for Square 2D
        square.draw2D();

        /*
        // Constructor injection into Circle
        Draw2D draw2D = new Draw2D();
        Circle circle = new Circle(draw2D);
        circle.draw();

        // Setter injection into Square
        Square square = new Square();
        square.setDraw2D(draw2D);
        square.draw();
        */

    }
}
