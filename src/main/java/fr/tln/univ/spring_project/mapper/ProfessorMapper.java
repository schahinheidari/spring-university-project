package fr.tln.univ.spring_project.mapper;

import fr.tln.univ.spring_project.dto.professor.AddProfessorDTO;
import fr.tln.univ.spring_project.dto.professor.UpdateProfessorDTO;
import fr.tln.univ.spring_project.dto.professor.ViewProfessorDTO;
import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Professor;
import fr.tln.univ.spring_project.enums.Gender;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class ProfessorMapper {
    private final ModelMapper mapper;

    public Professor toEntity(AddProfessorDTO addProfessorDTO){
        Professor professor = mapper.map(addProfessorDTO, Professor.class);

        professor.setGender(addProfessorDTO.getGenderString()
                .equals("MALE") ? Gender.MALE : Gender.FEMALE);
        professor.setBirthDay(new Date(addProfessorDTO.getBirthDayTimeStamp()));

        return professor;
    }
    public Professor toEntity(UpdateProfessorDTO updateProfessorDTO){
        Professor professor = mapper.map(updateProfessorDTO, Professor.class);

        professor.setGender(updateProfessorDTO.getGenderString()
                .equals("MALE") ? Gender.MALE : Gender.FEMALE);
        professor.setBirthDay(new Date(updateProfessorDTO.getBirthDayTimeStamp()));

        return professor;
    }

    public ViewProfessorDTO toViewDto(Professor professor){
        ViewProfessorDTO viewProfessorDTO = mapper.map(professor, ViewProfessorDTO.class);

        List<Integer> courseCode = professor.getCourses().stream()
                .map(Course::getCode)
                .toList();
        viewProfessorDTO.setCourseCodes(courseCode);

        viewProfessorDTO.setBirthDayTimeStamp(professor.getBirthDay().getTime());

        viewProfessorDTO.setGenderString(professor.getGender().name());

        return viewProfessorDTO;
    }

    public List<ViewProfessorDTO> toListViewDTO(List<Professor> professorList) {
        return professorList.stream().map(this::toViewDto).toList();
    }

}
