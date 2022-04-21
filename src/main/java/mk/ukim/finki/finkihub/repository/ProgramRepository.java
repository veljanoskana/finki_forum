package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {

}
