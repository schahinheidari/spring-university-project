package fr.tln.univ.spring_project.dto.student;

import fr.tln.univ.spring_project.dto.user.AddUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AddStudentDTO extends AddUserDTO {
    @Positive
    private long stdNumber;

    @NotBlank
    private String academicLevel;
}
