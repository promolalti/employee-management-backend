package role.service;

import role.dto.RoleRequest;
import role.dto.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse createRole(RoleRequest request);

    RoleResponse getRoleById(Long id);

    List<RoleResponse> getAllRoles();

    RoleResponse updateRole(Long id, RoleRequest request);

    void deleteRole(Long id);
}
