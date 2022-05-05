package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {
    List<Program> findAll();

    Optional<Program> findById(Integer id);
}
