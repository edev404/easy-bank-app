package tech.edev404.easybank.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.edev404.easybank.model.entity.enums.RoleEnum;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "mobile_number", unique = true, nullable = false, length = 15)
    private String mobileNumber;
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
