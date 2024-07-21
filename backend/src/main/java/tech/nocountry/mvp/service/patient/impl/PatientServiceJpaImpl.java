package tech.nocountry.mvp.service.patient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.mapper.patient.PatientMapper;
import tech.nocountry.mvp.model.dto.PatientDTO;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceJpaImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceJpaImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.patientDTOToPatient(patientDTO);
        return patientRepository.save(patient);
    }

    @Override
    public boolean deletePatient(UUID patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            patientRepository.deleteById(patientId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Patient> updatePatient(UUID patientId, PatientDTO patientDTO) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            patientMapper.patientDTOToPatient(patientDTO, patient);
            patientRepository.save(patient);
        }
        return patientOptional;
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
}