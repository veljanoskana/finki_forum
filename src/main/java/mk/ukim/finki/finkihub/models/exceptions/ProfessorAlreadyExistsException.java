package mk.ukim.finki.finkihub.models.exceptions;

public class ProfessorAlreadyExistsException extends Exception {
    public ProfessorAlreadyExistsException() {
        super("Professor already exists!");
    }
}
