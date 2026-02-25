package com.example.hibernateStart;

import com.example.hibernateStart.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main{
    public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(User.class).buildSessionFactory();

    Session session = sessionFactory.getCurrentSession();

    //define object
    User user = new User(1,"Ahemd","Salah","ahmed.salah@gmail.com");
    session.beginTransaction(); // fixed step
    session.save(user);
    session.getTransaction().commit(); //save the commit
/*
    //retrieve object
    session.beginTransaction();
    User user1 = session.get(User.class,1);

    //update object
    session.beginTransaction();
        //fetch
        User user2 = session.get(User.class,1);
        user2.setPassword("123456");
        session.save(user2);
        session.getTransaction().commit(); //save the commit

    //delete object
        //fetch
        User user3 = session.get(User.class,1);
        //delete
        session.delete(user3);
        session.getTransaction().commit(); //save the commit
*/
    }
}
