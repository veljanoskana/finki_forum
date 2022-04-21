package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
