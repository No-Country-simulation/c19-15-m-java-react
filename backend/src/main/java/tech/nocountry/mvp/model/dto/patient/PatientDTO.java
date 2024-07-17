package tech.nocountry.mvp.model.dto.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private Gender gender;
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
    private String phone;
    @Email
    private String email;
    private MedicalHistory medicalHistory;
}