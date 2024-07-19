package tech.nocountry.mvp.model.dto.medicalHistory;

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
    private LocalDate dateOfElaboration;
    private int age;
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
}