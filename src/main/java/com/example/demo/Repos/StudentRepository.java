package com.example.demo.Repos;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.Models.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);
}
