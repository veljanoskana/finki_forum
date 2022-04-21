package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
}
