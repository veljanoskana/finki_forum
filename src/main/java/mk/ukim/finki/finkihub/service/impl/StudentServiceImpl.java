package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Program;
import mk.ukim.finki.finkihub.models.Role;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.models.exceptions.InvalidArgumentsException;
import mk.ukim.finki.finkihub.models.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.finkihub.models.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.finkihub.repository.StudentRepository;
import mk.ukim.finki.finkihub.service.StudentService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
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
    public Optional<Student> findByIndexAndPassword(Integer id, String password) {
        return this.studentRepository.findByIndexAndPassword(id, password);
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student register(Integer index, String name, String surname, String password, String repeat, Preference preference, Program program, Role role) throws InvalidArgumentsException, PasswordsDoNotMatchException, UsernameAlreadyExistsException {
        if (index == null || password == null || password.isEmpty())
            throw new InvalidArgumentsException();

        if (!password.equals(repeat))
            throw new PasswordsDoNotMatchException();

        if (this.studentRepository.findById(index).isPresent())
            throw new UsernameAlreadyExistsException();

        Student student = new Student(index, name, surname, password, preference, program, role);
        return studentRepository.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.studentRepository.findById(Integer.parseInt(username)).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
