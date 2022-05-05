package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Optional<Course> findById(Integer id);

    void save(Course course);
}
