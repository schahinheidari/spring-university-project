package fr.tln.univ.spring_project.dto.course;

import fr.tln.univ.spring_project.dto.base.UpdateBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCourseDTO extends UpdateBaseDTO {
    @NotBlank
    private String title;

    @Positive
    private int units;
}
