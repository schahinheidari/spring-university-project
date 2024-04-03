package fr.tln.univ.spring_project.dto.user;

import fr.tln.univ.spring_project.dto.base.AddBaseDTO;
import fr.tln.univ.spring_project.dto.base.ViewBaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
public class ViewUserDTO extends ViewBaseDTO {
    private String name;
    private String family;
    private long nationalCode;
    private String gender;
    private long birthDay;
    private String username;

}
