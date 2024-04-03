package fr.tln.univ.spring_project.mapper;

import fr.tln.univ.spring_project.dto.course.AddCourseDTO;
import fr.tln.univ.spring_project.dto.course.ViewCourseDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Student;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CourseMapper {
    private final ModelMapper mapper;

    public Course toEntity(AddCourseDTO addCourseDTO){
        return mapper.map(addCourseDTO, Course.class);
    }
    public Course toEntity(UpdateCourseDTO updateCourseDTO){
        return mapper.map(updateCourseDTO, Course.class);
    }

    public ViewCourseDTO toViewDto(Course course){
        ViewCourseDTO viewCourseDTO = mapper.map(course, ViewCourseDTO.class);

        if (course.getProfessor() != null){
            String professor = course.getProfessor().getName() + " " + course.getProfessor().getFamily();
            viewCourseDTO.setNameProfessor(professor);
        }
        List<Long> studentNumbers = course.getStudents().stream()
                .map(Student::getStdNumber)
                .collect(Collectors.toList());
        viewCourseDTO.setStudentNumbers(studentNumbers);
        return viewCourseDTO;
    }

}
