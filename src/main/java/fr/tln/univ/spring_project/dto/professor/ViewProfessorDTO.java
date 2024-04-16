package fr.tln.univ.spring_project.dto.professor;

import fr.tln.univ.spring_project.dto.user.ViewUserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewProfessorDTO extends ViewUserDTO {
    private long code;
    private String academicRank;
    private List<Integer> courseCodes;
}
