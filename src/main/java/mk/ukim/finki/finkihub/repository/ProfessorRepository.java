package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
