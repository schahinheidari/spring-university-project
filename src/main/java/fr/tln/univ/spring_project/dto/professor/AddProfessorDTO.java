package fr.tln.univ.spring_project.dto.professor;

import fr.tln.univ.spring_project.dto.user.AddUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProfessorDTO extends AddUserDTO {
    @Positive
    private int code;

    @NotBlank
    private String academicRank;
}
