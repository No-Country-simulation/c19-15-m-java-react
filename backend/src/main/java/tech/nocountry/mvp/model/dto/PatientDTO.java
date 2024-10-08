package tech.nocountry.mvp.model.dto;

import lombok.*;
import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.enumeration.Gender;
import tech.nocountry.mvp.enumeration.Role;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PatientDTO {
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
    private String email;
    private String password;
    private MedicalHistory medicalHistoryId;
    private Role role;
}