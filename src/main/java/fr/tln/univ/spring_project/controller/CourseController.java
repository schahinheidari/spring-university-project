package fr.tln.univ.spring_project.controller;

import fr.tln.univ.spring_project.dto.course.AddCourseDTO;
import fr.tln.univ.spring_project.dto.course.UpdateCourseDTO;
import fr.tln.univ.spring_project.dto.course.ViewCourseDTO;
import fr.tln.univ.spring_project.dto.professor.ViewProfessorDTO;
import fr.tln.univ.spring_project.dto.student.ViewStudentDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Professor;
import fr.tln.univ.spring_project.entity.Student;
import fr.tln.univ.spring_project.mapper.CourseMapper;
import fr.tln.univ.spring_project.mapper.ProfessorMapper;
import fr.tln.univ.spring_project.mapper.StudentMapper;
import fr.tln.univ.spring_project.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/v1/")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final ProfessorMapper professorMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewCourseDTO save(@RequestBody AddCourseDTO addCourseDTO){
        Course course = courseService.save(courseMapper.toEntity(addCourseDTO));
        return courseMapper.toViewDto(course);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewCourseDTO update(@RequestBody UpdateCourseDTO updateCourseDTO){
        Course course = courseService.save(courseMapper.toEntity(updateCourseDTO));
        return courseMapper.toViewDto(course);
    }
    @DeleteMapping("/dalete/{}id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        courseService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewCourseDTO findById(@PathVariable Long id){
        return courseMapper.toViewDto(courseService.findById(id));
    }

    @GetMapping("/list")
    public List<ViewCourseDTO> findAll(){
        return courseMapper.toListViewDTO(courseService.findAll());
    }

    @GetMapping("/{codeCourse}/students")
    @ResponseStatus(HttpStatus.OK)
    public List<ViewStudentDTO> listStudents(@PathVariable int codeCourse){
        List<Student> students = courseService.listStudents(codeCourse);
        return studentMapper.toListViewDTO(students);
    }

    @PostMapping("/{codeCourse}/students/add/{stdNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void addStudent(@PathVariable int codeCourse, @PathVariable long stdNumber){
        courseService.addStudent(codeCourse, stdNumber);
    }

    @DeleteMapping("/{codeCourse}/students/delete/{stdNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void removeStudent(@PathVariable int codeCourse, @PathVariable long stdNumber){
        courseService.removeStudent(codeCourse, stdNumber);
    }

    @PostMapping("/{codeCourse}/professor/add/{codeProfessor}")
    @ResponseStatus(HttpStatus.OK)
    public void addProfessor(@PathVariable int codeCourse, @PathVariable int codeProfessor){
        courseService.addProfessor(codeCourse, codeProfessor);
    }

    @DeleteMapping("/{codeCourse}/professor/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeProfessor(@PathVariable int codeCourse){
        courseService.removeProfessor(codeCourse);
    }

    @GetMapping("{codeCourse}/professor")
    public ViewProfessorDTO getProfessor(@PathVariable int codeCourse){
        Professor professor = courseService.getProfessor(codeCourse);
        return professorMapper.toViewDto(professor);
    }
}
