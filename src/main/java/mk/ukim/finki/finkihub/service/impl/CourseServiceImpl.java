package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.repository.CourseRepository;
import mk.ukim.finki.finkihub.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return this.courseRepository.findById(id);
    }
}
