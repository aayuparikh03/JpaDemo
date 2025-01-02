package org.example.dao;

import org.example.entities.Student;

import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student);
    Student getStudentByID(long id);
    List<Student> getAllStudents();
    void UpdateStudent(Student student);
    void deleteStudent(long id);
}
