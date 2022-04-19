package mk.ukim.finki.finkihub.models;

import lombok.Data;

@Data
public class Student {

    private Integer index;

    private String name;

    private String surname;

    private Preference preference;

    private Program program;

    public Student() {}

    public Student(Integer index, String name, String surname, Preference preference, Program program) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.preference = preference;
        this.program = program;
    }
}
