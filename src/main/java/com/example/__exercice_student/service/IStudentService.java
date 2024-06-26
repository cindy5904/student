package com.example.__exercice_student.service;

import com.example.__exercice_student.model.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    List<Student> searchStudents(String search);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);


}
