package mk.ukim.finki.finkihub.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    private String surname;

    private String link;

    @ManyToMany
    private List<Course> teachingCourses;

    public Professor() {
    }

    public Professor(Integer ID, String name, String surname, String link) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.link = link;
    }

    public Professor(String firstName, String lastName, String link, List<Course> courses) {
        this.name = firstName;
        this.surname = lastName;
        this.link = link;
        this.teachingCourses = courses;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }
}
