package role.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Builder
public class RoleResponse {

    private Long id;
    private String roleCode;
    private String roleName;
    private String description;
    private String status;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
