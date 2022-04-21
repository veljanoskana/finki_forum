package mk.ukim.finki.finkihub.bootstrap;

import lombok.Getter;
import mk.ukim.finki.finkihub.models.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Student> students = new ArrayList<>();
    public List<Preference> preferences = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();
    public List<Program> programs = new ArrayList<>();
    public List<Review> reviews = new ArrayList<>();
    public List<Comment> comments = new ArrayList<>();
    public List<Professor> professors = new ArrayList<>();


    @PostConstruct
    public void init() {
//        GENERATING PROGRAMS
        programs.add(new Program(1, "SEIS", courses));

//        GENERATING PREFERENCES
        preferences.add(new Preference(1, "Fullstack", courses));

//        GENERATING STUDENT.
        students.add(new Student(191005, "Ana", "Veljanoska", "123", preferences.get(0), programs.get(0)));

//        GENERATING REVIEW
        comments.add(new Comment(1, students.get(0), LocalDateTime.now(), "some comment"));
        List<String> pros = new ArrayList<>();
        List<String> cons = new ArrayList<>();
        pros.add("Good!");
        cons.add("Bad!");
        reviews.add(new Review(1, comments, pros, cons));

//        GENERATING PROFESSOR
        professors.add(new Professor(1, "Sasho", "Gramatikov", "#"));

//        GENERATING COURSE
        courses.add(new Course("xxx", 3, true, reviews.get(0), null, preferences, professors));

    }
}
