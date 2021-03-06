package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Professor;
import mk.ukim.finki.finkihub.repository.ProfessorRepository;
import mk.ukim.finki.finkihub.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void save(Professor professor) {
        this.professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> findByLink(String link) {
        return this.professorRepository.findByLink(link);
    }
}
