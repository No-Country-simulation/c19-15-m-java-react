package tech.nocountry.mvp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.nocountry.mvp.domain.enums.Specialty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private Specialty specialty;
    private int licenseNumber;
    private int experience;
    private String phoneNumber;
    private String email;
    private String officeHours;
}