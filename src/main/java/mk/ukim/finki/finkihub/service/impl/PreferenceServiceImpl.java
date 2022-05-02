package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Preference;
import mk.ukim.finki.finkihub.models.Student;
import mk.ukim.finki.finkihub.repository.PreferenceRepository;
import mk.ukim.finki.finkihub.repository.StudentRepository;
import mk.ukim.finki.finkihub.service.PreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final StudentRepository studentRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository,
                                 StudentRepository studentRepository) {
        this.preferenceRepository = preferenceRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Preference> findAll() {
        return this.preferenceRepository.findAll();
    }

    @Override
    public void changePreference(Integer id) {
        Student student = this.studentRepository.findById(191005).get();
        Preference preference = this.preferenceRepository.findById(id).get();
        student.setPreference(preference);
        this.studentRepository.save(student);
    }
}
