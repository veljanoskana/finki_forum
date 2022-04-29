package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Course;
import mk.ukim.finki.finkihub.models.Personal;

import java.util.List;

public interface PersonalService {
    List<Course> listAllCoursesInPersonal(Integer id);
    Personal getActivePersonal(Integer index);
    Personal addCourseToPersonal(Integer index, Integer courseId);
}
