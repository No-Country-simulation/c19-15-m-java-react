package tech.nocountry.mvp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.nocountry.mvp.domain.enums.Gender;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private Address address;
    private String phone;
    private String email;
    private MedicalHistory medicalHistory;
}