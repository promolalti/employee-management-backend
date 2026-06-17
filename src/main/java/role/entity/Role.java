package role.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_role_code", columnNames = "role_code")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_code", nullable = false, unique = true, length = 50)
    private String roleCode;

    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        this.createdAt = now;
        this.updatedAt = now;

        if (this.status == null) {
            this.status = "ACTIVE";
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}