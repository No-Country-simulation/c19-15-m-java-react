package tech.nocountry.mvp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import tech.nocountry.mvp.enumeration.Gender;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID patientId;
    @Column(nullable = false, unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String phone;
    @Email
    @NotNull
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MedicalHistory medicalHistoryId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_doctor",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctorList = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> role = new HashSet<>();
}