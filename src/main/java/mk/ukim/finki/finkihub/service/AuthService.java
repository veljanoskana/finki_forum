package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.models.exceptions.InvalidArgumentsException;
import mk.ukim.finki.finkihub.models.exceptions.InvalidUserCredentialsException;

public interface AuthService {

    Student login(String username, String password) throws InvalidUserCredentialsException, InvalidArgumentsException;

}
