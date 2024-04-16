package fr.tln.univ.spring_project.controller;


import fr.tln.univ.spring_project.dto.course.ViewCourseDTO;
import fr.tln.univ.spring_project.dto.student.AddStudentDTO;
import fr.tln.univ.spring_project.dto.student.UpdateStudentDTO;
import fr.tln.univ.spring_project.dto.student.ViewStudentDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Student;
import fr.tln.univ.spring_project.mapper.CourseMapper;
import fr.tln.univ.spring_project.mapper.StudentMapper;
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
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewStudentDTO save(@RequestBody AddStudentDTO addStudentDTO){
        Student student = studentService.save(studentMapper.toEntity(addStudentDTO));
        return studentMapper.toViewDto(student);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewStudentDTO update(@RequestBody UpdateStudentDTO updateStudentDTO){
        Student student = studentService.save(studentMapper.toEntity(updateStudentDTO));
        return studentMapper.toViewDto(student);
    }
    @DeleteMapping("/dalete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewStudentDTO findById(@PathVariable Long id){
        return studentMapper.toViewDto(studentService.findById(id));
    }

    @GetMapping("/list")
    public List<ViewStudentDTO> findAll(){
        return studentMapper.toListViewDTO(studentService.findAll());
    }

    @GetMapping("/{stdNumber}/course/list")
    public List<ViewCourseDTO> listCoursesStudent(@PathVariable long stdNumber){
        List<Course> courses = studentService.listCoursesStudent(stdNumber);
        return courseMapper.toListViewDTO(courses);
    }
}
