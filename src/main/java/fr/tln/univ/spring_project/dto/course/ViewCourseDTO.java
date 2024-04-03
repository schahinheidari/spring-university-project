package fr.tln.univ.spring_project.dto.course;

import fr.tln.univ.spring_project.dto.base.ViewBaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewCourseDTO extends ViewBaseDTO {
    private int code;
    private String title;
    private int units;
    private String nameProfessor;
    private List<Long> studentNumbers;
}
