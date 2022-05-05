package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Preference;

import java.util.List;
import java.util.Optional;

public interface PreferenceService {
    List<Preference> findAll();

    void changePreference(Integer id, Integer index);

    Optional<Preference> findById(Integer id);

    void save(Preference preference);
}
