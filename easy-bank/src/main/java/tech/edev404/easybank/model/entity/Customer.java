package tech.edev404.easybank.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @ColumnDefault(value = "true")
    private Boolean enabled;
    @ColumnDefault(value = "true")
    private Boolean accountNonLocked;
    @ColumnDefault(value = "true")
    private Boolean credentialsNonExpired;
    @ColumnDefault(value = "true")
    private Boolean accountNonExpired;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
	private RoleEnum authority;
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    @UpdateTimestamp
    private LocalDateTime lastModified;

}
