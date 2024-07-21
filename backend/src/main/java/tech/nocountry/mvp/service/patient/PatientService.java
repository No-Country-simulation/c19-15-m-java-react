package tech.nocountry.mvp.service.patient;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.PatientDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientService {
    Patient createPatient(PatientDTO patientDTO);
    boolean deletePatient(UUID patientId);
    Optional<Patient> updatePatient(UUID patientId, PatientDTO patientDTO);
    List<Patient> findAllPatients();
    Optional<Patient> findByEmail(String email);
}