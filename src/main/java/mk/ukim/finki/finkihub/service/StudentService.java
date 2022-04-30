package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Integer id);
}
