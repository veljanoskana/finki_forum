package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findById(Integer id);

    void save(Student student);
}
