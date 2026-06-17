package role.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleRequest {

    @NotBlank
    private String roleCode;

    @NotBlank
    private String roleName;

    private String description;

    private String status;
}
