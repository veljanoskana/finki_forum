package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.models.exceptions.InvalidArgumentsException;
import mk.ukim.finki.finkihub.models.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.finkihub.repository.StudentRepository;
import mk.ukim.finki.finkihub.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final StudentRepository studentRepository;

    public AuthServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student login(String username, String password) throws InvalidUserCredentialsException, InvalidArgumentsException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return studentRepository.findByIndexAndPassword(Integer.parseInt(username),
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
