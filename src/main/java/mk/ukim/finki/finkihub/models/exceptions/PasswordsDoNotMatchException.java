package mk.ukim.finki.finkihub.models.exceptions;

public class PasswordsDoNotMatchException extends Exception {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match!");
    }
}
