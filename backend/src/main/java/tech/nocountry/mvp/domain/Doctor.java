package tech.nocountry.mvp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import tech.nocountry.mvp.enumeration.Specialty;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Doctor {
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
    private String email;
    private String officeHours;
}