package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.models.Personal;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.repository.CourseRepository;
import mk.ukim.finki.finkihub.repository.PersonalRepository;
import mk.ukim.finki.finkihub.repository.StudentRepository;
import mk.ukim.finki.finkihub.service.PersonalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public PersonalServiceImpl(PersonalRepository personalRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.personalRepository = personalRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> listAllCoursesInPersonal(Integer id) {
        return this.personalRepository.findById(id).get().getPersonalCourses();
    }

    @Override
    public Personal getActivePersonal(Integer index) {
        Student student = this.studentRepository.findById(index).get();
        return this.personalRepository
                .findByOwner(student)
                .get();
    }


    @Override
    public Personal addCourseToPersonal(Integer index, Integer courseId) {
        Personal personal = this.getActivePersonal(index);
        Course course = this.courseRepository.getById(courseId);
        personal.getPersonalCourses().add(course);
        return this.personalRepository.save(personal);
    }
}
