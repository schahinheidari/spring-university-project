package fr.tln.univ.spring_project.dto.student;

import fr.tln.univ.spring_project.dto.user.ViewUserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewStudentDTO extends ViewUserDTO {
    private long stdNumber;
    private String academicLevel;
    private List<Integer> courseCode;

}
