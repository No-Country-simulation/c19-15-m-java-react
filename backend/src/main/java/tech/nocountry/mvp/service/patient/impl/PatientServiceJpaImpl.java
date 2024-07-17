package tech.nocountry.mvp.service.patient.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.mapper.patient.PatientMapper;
import tech.nocountry.mvp.model.dto.patient.PatientDTO;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceJpaImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.patientDTOToPatient(patientDTO);
        return patientRepository.save(patient);
    }

    @Override
    public boolean deletePatient(UUID patientId) {
        return false;
    }

    @Override
    public Optional<Patient> updatePatient(UUID patientId, PatientDTO patientDTO) {
        return Optional.empty();
    }
}