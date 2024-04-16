package fr.tln.univ.spring_project.controller;


import fr.tln.univ.spring_project.dto.course.ViewCourseDTO;
import fr.tln.univ.spring_project.dto.professor.AddProfessorDTO;
import fr.tln.univ.spring_project.dto.professor.UpdateProfessorDTO;
import fr.tln.univ.spring_project.dto.professor.ViewProfessorDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Professor;
import fr.tln.univ.spring_project.mapper.CourseMapper;
import fr.tln.univ.spring_project.mapper.ProfessorMapper;
import fr.tln.univ.spring_project.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor/v1/")
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;
    private final CourseMapper courseMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewProfessorDTO save(@RequestBody AddProfessorDTO addProfessorDTO){
        Professor professor = professorService.save(professorMapper.toEntity(addProfessorDTO));
        return professorMapper.toViewDto(professor);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewProfessorDTO update(@RequestBody UpdateProfessorDTO updateProfessorDTO){
        Professor professor = professorService.save(professorMapper.toEntity(updateProfessorDTO));
        return professorMapper.toViewDto(professor);
    }
    @DeleteMapping("/dalete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        professorService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewProfessorDTO findById(@PathVariable Long id){
        return professorMapper.toViewDto(professorService.findById(id));
    }

    @GetMapping("/list")
    public List<ViewProfessorDTO> findAll(){
        return professorMapper.toListViewDTO(professorService.findAll());
    }

    @GetMapping("/{codeProfessor}/course/list")
    public List<ViewCourseDTO> listCoursesProfessor(@PathVariable int codeProfessor){
        List<Course> courses = professorService.listCoursesProfessor(codeProfessor);
        return courseMapper.toListViewDTO(courses);
    }
}
