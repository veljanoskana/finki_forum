package mk.ukim.finki.finkihub.models;

import lombok.Data;

import java.util.List;

@Data
public class Program {

    private Integer ID;

    private List<Course> coursesInProgram;

    public Program() {}

    public Program(Integer ID, List<Course> coursesInProgram) {
        this.ID = ID;
        this.coursesInProgram = coursesInProgram;
    }
}
