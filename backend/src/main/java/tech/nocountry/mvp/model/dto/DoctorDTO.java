package tech.nocountry.mvp.model.dto;

import jakarta.validation.constraints.Email;
import lombok.*;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.enumeration.Role;
import tech.nocountry.mvp.enumeration.Specialty;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class DoctorDTO {
    private String firstName;
    private String lastName;
    private Specialty specialty;
    private Integer licenseNumber;
    private Integer experience;
    private String phoneNumber;
    private String email;
    private String password;
    private String officeHours;
    private Role role;
    private List<Appointment> appointments;
    private List<Patient> patientList = new ArrayList<>();
}