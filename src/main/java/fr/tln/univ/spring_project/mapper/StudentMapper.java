package fr.tln.univ.spring_project.mapper;

import fr.tln.univ.spring_project.dto.student.AddStudentDTO;
import fr.tln.univ.spring_project.dto.student.UpdateStudentDTO;
import fr.tln.univ.spring_project.dto.student.ViewStudentDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Student;
import fr.tln.univ.spring_project.enums.Gender;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class StudentMapper {
    private final ModelMapper mapper;

    public Student toEntity(AddStudentDTO addStudentDTO) {
        Student student = mapper.map(addStudentDTO, Student.class);

        student.setGender(addStudentDTO.getGenderString()
                .equals("MALE") ? Gender.MALE : Gender.FEMALE);
        student.setBirthDay(new Date(addStudentDTO.getBirthDayTimeStamp()));

        return student;
    }

    public Student toEntity(UpdateStudentDTO updateStudentDTO) {
        Student student = mapper.map(updateStudentDTO, Student.class);

        student.setGender(updateStudentDTO.getGenderString()
                .equals("MALE") ? Gender.MALE : Gender.FEMALE);
        student.setBirthDay(new Date(updateStudentDTO.getBirthDayTimeStamp()));

        return student;
    }

    public ViewStudentDTO toViewDto(Student student) {
        ViewStudentDTO viewStudentDTO = mapper.map(student, ViewStudentDTO.class);

        List<Integer> coursesCode = student.getCourses().stream()
                .map(Course::getCode)
                .toList();
        viewStudentDTO.setCourseCode(coursesCode);

        viewStudentDTO.setBirthDayTimeStamp(student.getBirthDay().getTime());

        viewStudentDTO.setGenderString(student.getGender().name());

        return viewStudentDTO;
    }

    public List<ViewStudentDTO> toListViewDTO(List<Student> studentList) {
        return studentList.stream().map(this::toViewDto).toList();
    }
}
