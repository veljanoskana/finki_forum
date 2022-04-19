package mk.ukim.finki.finkihub.models;

import lombok.Data;

import java.util.List;

@Data
public class Preference {

    private Integer ID;

    private String name;

    private List<Course> suggestedCourses;

    public Preference() {}

    public Preference(Integer ID, String name, List<Course> suggestedCourses) {
        this.ID = ID;
        this.name = name;
        this.suggestedCourses = suggestedCourses;
    }
}
