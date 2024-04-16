package fr.tln.univ.spring_project.dto.user;

import fr.tln.univ.spring_project.dto.base.ViewBaseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewUserDTO extends ViewBaseDTO {
    private String name;
    private String family;
    private long nationalCode;
    private String genderString;
    private Long birthDayTimeStamp;
    private String username;

}
