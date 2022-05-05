package mk.ukim.finki.finkihub.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    @ManyToMany
    private List<Course> suggestedCourses;

    public Preference() {
    }

    public Preference(Integer ID, String name, List<Course> suggestedCourses) {
        this.ID = ID;
        this.name = name;
        this.suggestedCourses = suggestedCourses;
    }

    public Preference(String preferenceName, List<Course> coursesInPreference) {
        this.name = preferenceName;
        this.suggestedCourses = coursesInPreference;
    }
}
