package tech.nocountry.mvp.mapper.patient.impl;

import org.springframework.stereotype.Component;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.mapper.patient.PatientMapper;
import tech.nocountry.mvp.model.dto.PatientDTO;

import java.util.UUID;

/*
@Component
public class PatientMapperImpl implements PatientMapper {
    @Override
    public Patient patientDTOToPatient(PatientDTO patientDTO) {
        return Patient.builder()
                .patientId(UUID.randomUUID())
                .userName(patientDTO.getUserName())
                .password(patientDTO.getPassword())
                .firstName(patientDTO.getFirstName())
                .lastName(patientDTO.getLastName())
                .birthDate(patientDTO.getBirthDate())
                .gender(patientDTO.getGender())
                .street(patientDTO.getStreet())
                .city(patientDTO.getCity())
                .province(patientDTO.getProvince())
                .postalCode(patientDTO.getPostalCode())
                .country(patientDTO.getCountry())
                .phone(patientDTO.getPhone())
                .email(patientDTO.getEmail())
                .medicalHistoryId(patientDTO.getMedicalHistoryId())
                .build();
    }

    @Override
    public Patient patientDTOToPatient(PatientDTO patientDTO, Patient patient) {
        if (patientDTO.getFirstName() != null) patient.setFirstName(patientDTO.getFirstName());
        if (patientDTO.getLastName() != null) patient.setLastName(patientDTO.getLastName());
        if (patientDTO.getBirthDate() != null) patient.setBirthDate(patientDTO.getBirthDate());
        if (patientDTO.getGender() != null) patient.setGender(patientDTO.getGender());
        if (patientDTO.getStreet() != null) patient.setStreet(patientDTO.getStreet());
        if (patientDTO.getCity() != null) patient.setCity(patientDTO.getCity());
        if (patientDTO.getProvince() != null) patient.setProvince(patientDTO.getProvince());
        if (patientDTO.getPostalCode() != null) patient.setPostalCode(patientDTO.getPostalCode());
        if (patientDTO.getCountry() != null) patient.setCountry(patientDTO.getCountry());
        if (patientDTO.getPhone() != null) patient.setPhone(patientDTO.getPhone());
        if (patientDTO.getEmail() != null) patient.setEmail(patientDTO.getEmail());
        return patient;
    }

    @Override
    public PatientDTO patientToPatientDTO(Patient patient) {
        return PatientDTO.builder()
                .userName(patient.getUserName())
                .password(patient.getPassword())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .birthDate(patient.getBirthDate())
                .gender(patient.getGender())
                .street(patient.getStreet())
                .city(patient.getCity())
                .province(patient.getProvince())
                .postalCode(patient.getPostalCode())
                .country(patient.getCountry())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .medicalHistoryId(patient.getMedicalHistoryId())
                .build();
    }
}*/

@Component
public class PatientMapperImpl implements PatientMapper {
    @Override
    public Patient patientDTOToPatient(PatientDTO patientDTO) {
        return Patient.builder()
                .patientId(UUID.randomUUID())
                .userName(patientDTO.getUserName())
                .password(patientDTO.getPassword())
                .email(patientDTO.getEmail())
                .build();
    }

    @Override
    public Patient patientDTOToPatient(PatientDTO patientDTO, Patient patient) {
        if (patientDTO.getUserName() != null) patient.setUserName(patientDTO.getUserName());
        if (patientDTO.getEmail() != null) patient.setEmail(patientDTO.getEmail());
        if (patientDTO.getPassword() != null) patient.setPassword(patientDTO.getPassword());
        return patient;
    }

    @Override
    public PatientDTO patientToPatientDTO(Patient patient) {
        return PatientDTO.builder()
                .userName(patient.getUserName())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .build();
    }
}