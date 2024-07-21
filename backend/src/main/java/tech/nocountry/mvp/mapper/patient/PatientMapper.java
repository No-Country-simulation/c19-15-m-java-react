package tech.nocountry.mvp.mapper.patient;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.PatientDTO;

public interface PatientMapper {

    Patient patientDTOToPatient(PatientDTO patientDTO);

    PatientDTO patientToPatientDTO(Patient patient);

    Patient patientDTOToPatient(PatientDTO patientDTO, Patient patient);
}