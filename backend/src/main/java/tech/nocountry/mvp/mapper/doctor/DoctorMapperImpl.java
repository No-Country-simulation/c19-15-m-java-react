package tech.nocountry.mvp.mapper.doctor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.model.dto.DoctorDTO;

import java.util.UUID;

@Component
public class DoctorMapperImpl implements DoctorMapper {

    private final PasswordEncoder passwordEncoder;

    public DoctorMapperImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DoctorDTO doctorToDoctorDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .password(doctor.getPassword())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .specialty(doctor.getSpecialty())
                .licenseNumber(doctor.getLicenseNumber())
                .experience(doctor.getExperience())
                .phoneNumber(doctor.getPhoneNumber())
                .email(doctor.getEmail())
                .officeHours(doctor.getOfficeHours())
                .role(doctor.getRole())
                .appointments(doctor.getAppointments())
                .patientList(doctor.getPatientList())
                .build();
    }

    @Override
    public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
        return Doctor.builder()
                .doctorId(UUID.randomUUID())
                .firstName(doctorDTO.getFirstName())
                .lastName(doctorDTO.getLastName())
                .specialty(doctorDTO.getSpecialty())
                .licenseNumber(doctorDTO.getLicenseNumber())
                .experience(doctorDTO.getExperience())
                .phoneNumber(doctorDTO.getPhoneNumber())
                .email(doctorDTO.getEmail())
                .officeHours(doctorDTO.getOfficeHours())
                .role(doctorDTO.getRole())
                .appointments(doctorDTO.getAppointments())
                .patientList(doctorDTO.getPatientList())
                .password(doctorDTO.getPassword())
                .build();
    }

    @Override
    public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO, Doctor doctor) {
        if (doctorDTO.getPassword() != null) doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
        if (doctorDTO.getFirstName() != null) doctor.setFirstName(doctorDTO.getFirstName());
        if (doctorDTO.getLastName() != null) doctor.setLastName(doctorDTO.getLastName());
        if (doctorDTO.getSpecialty() != null) doctor.setSpecialty(doctorDTO.getSpecialty());
        if (doctorDTO.getEmail() != null) doctor.setEmail(doctorDTO.getEmail());
        if (doctorDTO.getLicenseNumber() != null) doctor.setLicenseNumber(doctorDTO.getLicenseNumber());
        if (doctorDTO.getExperience() != null) doctor.setExperience(doctorDTO.getExperience());
        if (doctorDTO.getPhoneNumber() != null) doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        if (doctorDTO.getOfficeHours() != null) doctor.setOfficeHours(doctorDTO.getOfficeHours());
        if (doctorDTO.getRole() != null) doctor.setRole(doctorDTO.getRole());
        if (doctorDTO.getAppointments() != null) doctor.setAppointments(doctorDTO.getAppointments());
        if (doctorDTO.getPatientList() != null) doctor.setPatientList(doctorDTO.getPatientList());
        return doctor;
    }
}