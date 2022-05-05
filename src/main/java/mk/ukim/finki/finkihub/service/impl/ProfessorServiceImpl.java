package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Professor;
import mk.ukim.finki.finkihub.repository.ProfessorRepository;
import mk.ukim.finki.finkihub.service.ProfessorService;
import org.springframework.stereotype.Service;

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
}
