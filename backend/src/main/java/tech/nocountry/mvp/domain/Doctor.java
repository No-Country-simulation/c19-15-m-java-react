package tech.nocountry.mvp.domain;

import jakarta.persistence.*;
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
@Table(name = "doctor")
public class Doctor implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID doctorId;
    @Column(name = "password", nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private Integer licenseNumber;
    private Integer experience;
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private String email;
    private String officeHours;
    @ManyToMany(mappedBy = "doctorList", fetch = FetchType.LAZY)
    private List<Patient> patientList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }
}