package fr.tln.univ.spring_project.repository;

import fr.tln.univ.spring_project.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student>{

    Optional<Student> findByStdNumber(long stdNumber);
}
