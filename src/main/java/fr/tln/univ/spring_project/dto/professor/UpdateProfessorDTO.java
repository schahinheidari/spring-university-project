package fr.tln.univ.spring_project.dto.professor;

import fr.tln.univ.spring_project.dto.user.UpdateUserDTO;
import jakarta.validation.constraints.NotBlank;

public class UpdateProfessorDTO extends UpdateUserDTO {
    @NotBlank
    private String academicRank;
}
