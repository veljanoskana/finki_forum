package mk.ukim.finki.finkihub.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    private Integer year;

    private Boolean mandatory;

    @OneToMany
    private List<Comment> comments;

    public Course() {}

    public Course(String code, Integer year, Boolean mandatory, List<Comment> comments) {
        this.code = code;
        this.year = year;
        this.mandatory = mandatory;
        this.comments = comments;
    }
}
