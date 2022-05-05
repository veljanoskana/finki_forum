package mk.ukim.finki.finkihub.models.exceptions;

public class CourseAlreadyExistsException extends Exception {
    public CourseAlreadyExistsException() {
        super("Course already exists!");
    }
}
