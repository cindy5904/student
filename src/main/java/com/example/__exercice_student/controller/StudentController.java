package com.example.__exercice_student.controller;

import com.example.__exercice_student.model.Student;
import com.example.__exercice_student.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {
    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/formulaire")
    public String formAddStudent(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/formulaire")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        studentService.createStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/students")
    public String showAllStudents(@RequestParam(name="search", required = false) String search, Model model) {
        if(search == null) {
            model.addAttribute("students", studentService.getAllStudents());
        } else {
            model.addAttribute("students", studentService.searchStudents(search));
        }
       return "list";
    }

    @GetMapping("/student/{id}")
    public String showStudent(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "detail";
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam(value = "studentId") Long id) {
        System.out.println("Delete");
        studentService.deleteStudent(id);
        return new RedirectView("/students");
    }

    @GetMapping("/update")
    public String formUpdate(@RequestParam(value = "studentId") Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);

        return "form";
    }

    @PostMapping("/updateStudent/{id}")
    public RedirectView updateStudent(@PathVariable Long id, @ModelAttribute Student updatedStudent, Model model){
        studentService.updateStudent(id, updatedStudent);
        return new RedirectView("/student");
    }

}
