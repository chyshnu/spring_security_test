package me.chenyun.demo.rest;

import me.chenyun.demo.entity.Student;
import me.chenyun.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{studentId}")
    public List<Student> getStudent(@PathVariable("studentId") Long studentId) {
        return Collections.singletonList(studentService.getStudentById(studentId));
    }
}
