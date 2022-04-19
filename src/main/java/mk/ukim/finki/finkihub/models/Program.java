package mk.ukim.finki.finkihub.models;

import lombok.Data;

import java.util.List;

@Data
public class Program {

    private Integer ID;

    private String name;

    private List<Course> coursesInProgram;

    public Program() {}

    public Program(Integer ID, String name, List<Course> coursesInProgram) {
        this.ID = ID;
        this.name = name;
        this.coursesInProgram = coursesInProgram;
    }
}
