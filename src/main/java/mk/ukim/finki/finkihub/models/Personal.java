package mk.ukim.finki.finkihub.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @ManyToOne
    private Student owner;

    @ManyToMany
    private List<Course> personalCourses;

    public Personal() {}

    public Personal(Student owner, List<Course> personalCourses) {
        this.owner = owner;
        this.personalCourses = personalCourses;
    }
}
