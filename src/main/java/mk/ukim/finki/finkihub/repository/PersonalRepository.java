package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Personal;
import mk.ukim.finki.finkihub.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    Optional<Personal> findByOwner(Student student);
}
