package fr.tln.univ.spring_project.controller;

import fr.tln.univ.spring_project.dto.course.AddCourseDTO;
import fr.tln.univ.spring_project.dto.course.UpdateCourseDTO;
import fr.tln.univ.spring_project.dto.course.ViewCourseDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.mapper.CourseMapper;
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
    private final CourseMapper mapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Course save(@RequestBody AddCourseDTO addCourseDTO){
        return courseService.save(mapper.toEntity(addCourseDTO));
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Course update(@RequestBody UpdateCourseDTO updateCourseDTO){
        return courseService.save(mapper.toEntity(updateCourseDTO));
    }
    @DeleteMapping("/dalete/{}id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        courseService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewCourseDTO findById(@PathVariable Long id){
        return mapper.toViewDto(courseService.findById(id));
    }

    @GetMapping("/list")
    public List<Course> findAll(){
        return courseService.findAll();
    }
}
