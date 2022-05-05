package mk.ukim.finki.finkihub.models.exceptions;

public class PreferenceAlreadyExistsException extends Exception {
    public PreferenceAlreadyExistsException() {
        super("Preference already exists!");
    }
}
