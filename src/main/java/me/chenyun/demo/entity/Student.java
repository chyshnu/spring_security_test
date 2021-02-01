package me.chenyun.demo.entity;

import lombok.*;

import javax.persistence.*;

//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
@Table( name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "student_username_unique", columnNames = "username")
})
@Entity
public class Student {
    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
