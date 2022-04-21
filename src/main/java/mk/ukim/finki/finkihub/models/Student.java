package mk.ukim.finki.finkihub.models;

import lombok.Data;

@Data
public class Student {

    private Integer index;

    private String name;

    private String surname;

    private String password;

    private Preference preference;

    private Program program;

    public Student() {}

    public Student(Integer index, String name, String surname, String password, Preference preference, Program program) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.preference = preference;
        this.password = password;
        this.program = program;
    }
}
