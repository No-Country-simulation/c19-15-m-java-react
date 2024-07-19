package tech.nocountry.mvp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import tech.nocountry.mvp.enumeration.Gender;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MedicalHistory {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID medicalHistoryId;
    private LocalDate dateOfElaboration;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String nationality;
    private String civilStatus;
    private String occupation;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String emergencyContactFirstName;
    private String emergencyContactLastName;
    private String emergencyContactRelationship;
    private String emergencyContactPhoneNumber;
    private String previousIllnesses;
    private String surgeries;
    private String allergies;
    private String hospitalizations;
    private String currentMedication;
    private Boolean alcoholConsumption;
    private Boolean tobacco;
    private Boolean drugs;
    private Boolean diet;
    private Boolean exercise;
    private String symptoms;
    private String bloodPressure;
    private int heartRate;
    private float temperature;
    private int breathingFrequency;
    private String diagnosis;
    private String carePlan;
    private String doctorsNotes;
    @OneToOne(mappedBy = "medicalHistoryId")
    private Patient patient;
}