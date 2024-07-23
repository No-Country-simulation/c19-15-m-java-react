package tech.nocountry.mvp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.nocountry.mvp.enumeration.Role;
import tech.nocountry.mvp.enumeration.Specialty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Doctor implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID doctorId;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private int licenseNumber;
    private int experience;
    private String phoneNumber;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    private String officeHours;
    @ManyToMany(mappedBy = "doctorList", fetch = FetchType.LAZY)
    private List<Patient> patientList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}