package fr.tln.univ.spring_project.service;


import fr.tln.univ.spring_project.entity.Student;
import fr.tln.univ.spring_project.exception.ConflictException;
import fr.tln.univ.spring_project.exception.NotFoundException;
import fr.tln.univ.spring_project.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(Student student){
        Optional<Student> optional;
        optional = studentRepository.findByNationalCode(student.getNationalCode());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired National code is available in the system!");

        optional = studentRepository.findByUsername(student.getUsername());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired username is available in the system!");

        optional = studentRepository.findByStdNumber(student.getStdNumber());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired stdNumber is available in the system!");

        return studentRepository.save(student);

    }

    public Student findById(Long id){
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isEmpty()){
            throw new NotFoundException("student Not Found!");
        }
        return optional.get();
    }

    public Student update(Student student){
        findById(student.getId());
        return studentRepository.save(student);
    }

    public void deleteById(Long id){
        findById(id);
        studentRepository.deleteById(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findByStdNumber(int stdNumber){
        Optional<Student> optional = studentRepository.findByStdNumber(stdNumber);
        if (optional.isEmpty())
            throw new NotFoundException("Student not found!");
        return optional.get();
    }
}
