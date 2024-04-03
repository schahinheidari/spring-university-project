package fr.tln.univ.spring_project.dto.course;

import fr.tln.univ.spring_project.dto.base.AddBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCourseDTO extends AddBaseDTO {
    @Positive
    private int code;

    @NotBlank
    private String title;

    @Positive
    private int units;
}
