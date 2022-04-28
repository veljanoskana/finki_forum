package mk.ukim.finki.finkihub.service;

import mk.ukim.finki.finkihub.models.Program;

import java.util.List;

public interface ProgramService {
    List<Program> findAll();
}
