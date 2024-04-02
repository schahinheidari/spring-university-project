package fr.tln.univ.spring_project.repository;

import fr.tln.univ.spring_project.entity.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends UserRepository<Professor>{
    Optional<Professor> findByCode(int code);

}
