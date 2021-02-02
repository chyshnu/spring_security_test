package me.chenyun.demo.service;

import lombok.RequiredArgsConstructor;
import me.chenyun.demo.entity.Student;
import me.chenyun.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student queryById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> queryAll() {
        return studentRepository.findAll();
    }

    public void create(Student student) {
        studentRepository.save(student);
        System.out.println("[CREATE]" + student);
    }

    public void delete(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null) {
            studentRepository.delete(student);
            System.out.println("[DELETE]" + student);
        }
    }

    public void update(Student student) {
        if(studentRepository.existsById(student.getId())) {
            studentRepository.save(student);
            System.out.println("[UPDATE]" + student);
        }
    }
}
