package role.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import role.dto.RoleRequest;
import role.dto.RoleResponse;
import role.entity.Role;
import role.repository.RoleRepository;
import role.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleResponse createRole(RoleRequest request) {

        if (roleRepository.existsByRoleCode(request.getRoleCode())) {
            throw new RuntimeException(
                    "Role already exists with code: " + request.getRoleCode());
        }

        Role role = Role.builder()
                .roleCode(request.getRoleCode())
                .roleName(request.getRoleName())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();

        Role savedRole = roleRepository.save(role);

        return mapToResponse(savedRole);
    }

    @Override
    public RoleResponse getRoleById(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Role not found with id: " + id));

        return mapToResponse(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {

        return roleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse updateRole(Long id, RoleRequest request) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Role not found with id: " + id));

        role.setRoleName(request.getRoleName());
        role.setDescription(request.getDescription());
        role.setStatus(request.getStatus());

        Role updatedRole = roleRepository.save(role);

        return mapToResponse(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Role not found with id: " + id));

        roleRepository.delete(role);
    }

    private RoleResponse mapToResponse(Role role) {

        return RoleResponse.builder()
                .id(role.getId())
                .roleCode(role.getRoleCode())
                .roleName(role.getRoleName())
                .description(role.getDescription())
                .status(role.getStatus())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }
}