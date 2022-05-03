package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Program;
import mk.ukim.finki.finkihub.models.Role;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.repository.StudentRepository;
import mk.ukim.finki.finkihub.service.StudentService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student register(Integer index, String name, String surname, String password, String repeat, Preference preference, Program program, Role role) {
        Student student = new Student(index, name, surname, password, preference, program, role);
        return studentRepository.save(student);
    }

}
