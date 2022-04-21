package mk.ukim.finki.finkihub.repository;

import mk.ukim.finki.finkihub.models.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}
