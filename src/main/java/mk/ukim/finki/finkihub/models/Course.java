package mk.ukim.finki.finkihub.models;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private String code;

    private Integer year;

    private Boolean mandatory;

    private Review review;

    private List<StudyMaterial> materialsForCourse;

    private List<Preference> preferences;

    private List<Professor> professorsInCourse;

    public Course() {}

    public Course(String code, Integer year, Boolean mandatory, Review review, List<StudyMaterial> materialsForCourse, List<Preference> preferences, List<Professor> professorsInCourse) {
        this.code = code;
        this.year = year;
        this.mandatory = mandatory;
        this.review = review;
        this.materialsForCourse = materialsForCourse;
        this.preferences = preferences;
        this.professorsInCourse = professorsInCourse;
    }
}
