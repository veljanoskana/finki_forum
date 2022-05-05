package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Professor;

import java.util.Optional;

public interface ProfessorService {
    void save(Professor professor);

    Optional<Professor> findByLink(String link);
}
