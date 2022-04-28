package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Preference;

import java.util.List;

public interface PreferenceService {
    List<Preference> findAll();
}
