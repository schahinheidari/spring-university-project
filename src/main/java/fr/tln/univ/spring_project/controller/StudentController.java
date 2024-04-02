package fr.tln.univ.spring_project.controller;


import fr.tln.univ.spring_project.entity.Student;
import fr.tln.univ.spring_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1/")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student student){
        return studentService.save(student);
    }
    @DeleteMapping("/dalete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/list")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
