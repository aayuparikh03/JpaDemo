package org.example.dao;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class StudentDAOImpl implements StudentDAO{

    private final SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveStudent(Student student) {
        try(Session session=sessionFactory.openSession()){
            Transaction t= session.beginTransaction();
            session.persist(student);
            t.commit();
        }

    }

    @Override
    public Student getStudentByID(long id) {
        try(Session session= sessionFactory.openSession()) {
            return session.get(Student.class,id);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try (Session session= sessionFactory.openSession()){
            Query<Student> query=session.createQuery("FROM Student",Student.class);
            return query.list();
        }
    }

    @Override
    public void UpdateStudent(Student student) {
        try (Session session= sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            Student existingStudent=session.get(Student.class,student.getId());
            transaction.commit();

        }

    }

    @Override
    public void deleteStudent(long id) {
        try(Session session= sessionFactory.openSession()){
            Transaction transaction= session.beginTransaction();
            Student student=session.get(Student.class,id);
            if(student!=null){
                session.remove(student);
            }
            transaction.commit();
        }

    }
}
