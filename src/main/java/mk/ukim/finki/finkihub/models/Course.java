package mk.ukim.finki.finkihub.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;

    private Integer year;

    @OneToMany
    private List<Comment> comments;

    public Course() {}

    public Course(Integer ID, String name, Integer year, List<Comment> comments) {
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.comments = comments;
    }
}
