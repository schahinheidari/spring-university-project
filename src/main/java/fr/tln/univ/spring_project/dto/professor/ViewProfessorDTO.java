package fr.tln.univ.spring_project.dto.professor;

import fr.tln.univ.spring_project.dto.user.ViewUserDTO;

import java.util.List;

public class ViewProfessorDTO extends ViewUserDTO {
    private long code;
    private String academicRank;
    private List<Integer> courseCodes;
}
