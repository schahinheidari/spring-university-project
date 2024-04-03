package fr.tln.univ.spring_project.service;

import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.exception.ConflictException;
import fr.tln.univ.spring_project.exception.NotFoundException;
import fr.tln.univ.spring_project.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course save(Course course) {
        Optional<Course> course1 = courseRepository.findByCode(course.getCode());
        if (course1.isPresent())
            throw new ConflictException("the code with the desired code is available in the system!");
        return courseRepository.save(course);
    }

    public Course findById(Long id){
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isEmpty()){
            throw new NotFoundException("Course Not Found!");
        }
        return optional.get();
    }

    public Course update(Course courseUpdate){
        Course course = findById(courseUpdate.getId());
        courseUpdate.setCode(course.getCode());
        return courseRepository.save(courseUpdate);
    }

    public void deleteById(Long id){
        findById(id);
        courseRepository.deleteById(id);
    }
    public void deleteAll(){
        courseRepository.deleteAll();
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }
}
