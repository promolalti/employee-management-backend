package role.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import role.dto.RoleRequest;
import role.dto.RoleResponse;
import role.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponse> createRole(
            @Valid @RequestBody RoleRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleService.createRole(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(
            @PathVariable Long id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> updateRole(
            @PathVariable Long id,
            @Valid @RequestBody RoleRequest request) {

        return ResponseEntity.ok(roleService.updateRole(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(
            @PathVariable Long id) {

        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}