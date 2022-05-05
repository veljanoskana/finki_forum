package mk.ukim.finki.finkihub.models.exceptions;

public class UsernameAlreadyExistsException extends Exception {
    public UsernameAlreadyExistsException() {
        super("Username already exists!");
    }
}
