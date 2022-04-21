package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
