package tech.nocountry.mvp.model.dto.patient;

import jakarta.validation.constraints.Email;
import lombok.*;
import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.enumeration.Gender;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PatientDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String phone;
    @Email
    private String email;
    private MedicalHistory medicalHistoryId;
}