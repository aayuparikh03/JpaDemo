package org.example;

import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.entities.Student;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(org.example.entities.Student.class);
//        configuration.configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        StudentDAO studentDAO=new StudentDAOImpl(sessionFactory);
        Student student=new Student();
        student.setName("Harry Potter");
        Student student1=new Student();
        student1.setName("Dumbledore");

        System.out.println("Adding Student:"+ student);
        System.out.println("Adding Student:"+student1);
        studentDAO.saveStudent(student);
        studentDAO.saveStudent(student1);

        List<Student> students=studentDAO.getAllStudents();
        System.out.println("Students: "+students.toString());

        Student studentToUpdate=studentDAO.getStudentByID(1);
        System.out.println("Updating Student:"+studentToUpdate);
        if(studentToUpdate!=null){
            studentToUpdate.setName("Hermoinee");
            studentDAO.UpdateStudent(studentToUpdate);
        }
        Student updatedStudent=studentDAO.getStudentByID(1);
        System.out.println("Updated Student:"+updatedStudent);

        studentDAO.deleteStudent(2);
        System.out.println("Deleting student with id:"+2);
        List<Student> studentsAfterDelete=studentDAO.getAllStudents();
        System.out.println("Students:"+studentsAfterDelete.toString());

        sessionFactory.close();


    }
}

