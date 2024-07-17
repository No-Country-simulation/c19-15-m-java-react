package tech.nocountry.mvp.model.dto.medicalHistory;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import tech.nocountry.mvp.enumeration.Gender;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MedicalHistoryDTO {
    private UUID patientId;
    @NotBlank
    private LocalDate dateOfElaboration;
    @NotBlank
    private int age;
    @NotBlank
    private Gender gender;
    @NotBlank
    private String nationality;
    @NotBlank
    private String civilStatus;
    @NotBlank
    private String occupation;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String province;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;
    @NotBlank
    private String emergencyContactFirstName;
    @NotBlank
    private String emergencyContactLastName;
    @NotBlank
    private String emergencyContactRelationship;
    @NotBlank
    private String emergencyContactPhoneNumber;
    @NotBlank
    private String previousIllnesses;
    @NotBlank
    private String surgeries;
    @NotBlank
    private String allergies;
    @NotBlank
    private String hospitalizations;
    private String currentMedication;
    @NotBlank
    private Boolean alcoholConsumption;
    @NotBlank
    private Boolean tobacco;
    @NotBlank
    private Boolean drugs;
    @NotBlank
    private Boolean diet;
    @NotBlank
    private Boolean exercise;
    @NotBlank
    private String symptoms;
    @NotBlank
    private String bloodPressure;
    @NotBlank
    private int heartRate;
    @NotBlank
    private float temperature;
    @NotBlank
    private int breathingFrequency;
    private String diagnosis;
    @NotBlank
    private String carePlan;
    private String doctorsNotes;
}