package com.example.__exercice_student.service;

import com.example.__exercice_student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    private List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Student createStudent(Student student) {
        student.setId(currentId++);
        students.add(student);
        return student;
    }

    @Override
    public Student getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<Student> searchStudents(String search) {
        return students.stream()
                .filter(student -> student.getFirstname().toLowerCase().contains(search.toLowerCase()) ||
                        student.getLastname().toLowerCase().contains(search.toLowerCase())).toList();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setFirstname(student.getFirstname());
            existingStudent.setLastname(student.getLastname());
            existingStudent.setAge(student.getAge());
            return existingStudent;
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
