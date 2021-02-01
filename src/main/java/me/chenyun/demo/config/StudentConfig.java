package me.chenyun.demo.config;

import me.chenyun.demo.entity.Student;
import me.chenyun.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            List<Student> students = Arrays.asList(
                new Student("chenyun", "123456"),
                new Student("test1", "111111"),
                new Student("test2", "222222")
            );
            studentRepository.saveAll(students);
        };
    }
}
