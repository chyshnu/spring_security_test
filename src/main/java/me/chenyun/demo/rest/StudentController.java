package me.chenyun.demo.rest;

import lombok.RequiredArgsConstructor;
import me.chenyun.demo.entity.Student;
import me.chenyun.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.queryById(studentId);
    }
}
