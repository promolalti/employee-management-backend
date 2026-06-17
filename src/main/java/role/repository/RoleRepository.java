package role.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import role.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleCode(String roleCode);

    boolean existsByRoleCode(String roleCode);
}