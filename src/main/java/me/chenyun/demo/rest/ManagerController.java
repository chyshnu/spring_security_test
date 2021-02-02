package me.chenyun.demo.rest;

import lombok.RequiredArgsConstructor;
import me.chenyun.demo.entity.Student;
import me.chenyun.demo.service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/api/v1/students")
@RequiredArgsConstructor
public class ManagerController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> queryAll() {
        return studentService.queryAll();
    }

    @GetMapping("{id}")
    public Student queryById(@PathVariable("id") Long id) {
        return studentService.queryById(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")      // hasRole, hasAnyRole, hasAuthority, hasAnyAuthority
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void update(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.update(student);
    }
}
