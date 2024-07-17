package tech.nocountry.mvp.mapper.patient.impl;

import org.springframework.stereotype.Component;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.mapper.patient.PatientMapper;
import tech.nocountry.mvp.model.dto.patient.PatientDTO;

import java.util.UUID;

@Component
public class PatientMapperImpl implements PatientMapper {
    @Override
    public Patient patientDTOToPatient(PatientDTO patientDTO) {
        return Patient.builder()
                .patientId(UUID.randomUUID())
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
                .medicalHistory(patientDTO.getMedicalHistory())
                .build();
    }

    @Override
    public PatientDTO patientToPatientDTO(Patient patient) {
        return PatientDTO.builder()
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
                .medicalHistory(patient.getMedicalHistory())
                .build();
    }
}