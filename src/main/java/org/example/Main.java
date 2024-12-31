package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Student;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(),
                        new HashMap<>());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Student s1 = new Student();
            s1.setId(3);
            s1.setName("ABC");
            em.persist(s1);

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
}
