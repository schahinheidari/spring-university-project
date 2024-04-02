package fr.tln.univ.spring_project.service;


import fr.tln.univ.spring_project.entity.Professor;
import fr.tln.univ.spring_project.exception.ConflictException;
import fr.tln.univ.spring_project.exception.NotFoundException;
import fr.tln.univ.spring_project.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    
    private final ProfessorRepository professorRepository;

    public Professor save(Professor professor){
        Optional<Professor> optional;
        optional = professorRepository.findByNationalCode(professor.getNationalCode());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired National code is available in the system!");

        optional = professorRepository.findByUsername(professor.getUsername());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired username is available in the system!");

        optional = professorRepository.findByCode(professor.getCode());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired Code is available in the system!");

        return professorRepository.save(professor);

    }

    public Professor findById(Long id){
        Optional<Professor> optional = professorRepository.findById(id);
        if (optional.isEmpty()){
            throw new NotFoundException("Professor Not Found!");
        }
        return optional.get();
    }

    public Professor update(Professor professor){
        findById(professor.getId());
        return professorRepository.save(professor);
    }

    public void deleteById(Long id){
        findById(id);
        professorRepository.deleteById(id);
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }
    
}
