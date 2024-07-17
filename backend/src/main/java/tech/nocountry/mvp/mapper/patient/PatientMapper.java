package tech.nocountry.mvp.mapper.patient;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.patient.PatientDTO;

public interface PatientMapper {

    Patient patientDTOToPatient(PatientDTO patientDTO);

    PatientDTO patientToPatientDTO(Patient patient);
}