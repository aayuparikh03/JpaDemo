package org.example;

import org.example.entities.Student;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(org.example.entities.Student.class);
//        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        try{
            session.beginTransaction();
            Student s=new Student();
            s.setId(6);
            s.setName("Pasta");
            session.persist(s);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
