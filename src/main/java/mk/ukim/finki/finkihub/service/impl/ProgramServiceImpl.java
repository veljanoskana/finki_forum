package mk.ukim.finki.finkihub.service.impl;

import mk.ukim.finki.finkihub.models.Program;
import mk.ukim.finki.finkihub.repository.ProgramRepository;
import mk.ukim.finki.finkihub.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }
}
