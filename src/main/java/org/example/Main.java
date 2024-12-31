package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Student;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaDemo");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Student s1 = new Student();
            s1.setId(2);
            s1.setName("Aryan");
            em.persist(s1);

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
