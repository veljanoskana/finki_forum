package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Program;
import mk.ukim.finki.finkihub.models.Role;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.models.exceptions.InvalidArgumentsException;
import mk.ukim.finki.finkihub.models.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.finkihub.models.exceptions.UsernameAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService extends UserDetailsService {
    List<Student> findAll();

    Optional<Student> findById(Integer id);

    Optional<Student> findByIndexAndPassword(Integer id, String password);

    void save(Student student);

    Student register(Integer index, String name, String surname, String password, String repeat, Preference preference, Program program, Role role) throws InvalidArgumentsException, PasswordsDoNotMatchException, UsernameAlreadyExistsException;
}
