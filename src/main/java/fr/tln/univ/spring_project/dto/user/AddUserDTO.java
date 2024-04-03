package fr.tln.univ.spring_project.dto.user;

import fr.tln.univ.spring_project.dto.base.AddBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddUserDTO extends AddBaseDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String family;

    @Positive
    private long nationalCode;

    @NotBlank
    private String gender;

    @NotNull
    private long birthDayTimeStamp;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
