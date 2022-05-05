package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAll();

    @Override
    Optional<Course> findById(Integer id);

    Optional<Course> findByName(String name);
}
