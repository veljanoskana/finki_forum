package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.repository.PreferenceRepository;
import mk.ukim.finki.finkihub.service.PreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<Preference> findAll() {
        return this.preferenceRepository.findAll();
    }
}
