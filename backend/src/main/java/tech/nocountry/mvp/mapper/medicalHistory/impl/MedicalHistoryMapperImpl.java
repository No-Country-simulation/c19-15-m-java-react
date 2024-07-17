package tech.nocountry.mvp.mapper.medicalHistory.impl;

import org.springframework.stereotype.Component;
import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.mapper.medicalHistory.MedicalHistoryMapper;
import tech.nocountry.mvp.model.dto.medicalHistory.MedicalHistoryDTO;

import java.util.UUID;

@Component
public class MedicalHistoryMapperImpl implements MedicalHistoryMapper {
    @Override
    public MedicalHistory medicalHistoryDTOToMedicalHistory(MedicalHistoryDTO medicalHistoryDTO) {
        return MedicalHistory.builder()
                .medicalHistoryId(UUID.randomUUID())
                .dateOfElaboration(medicalHistoryDTO.getDateOfElaboration())
                .age(medicalHistoryDTO.getAge())
                .gender(medicalHistoryDTO.getGender())
                .nationality(medicalHistoryDTO.getNationality())
                .civilStatus(medicalHistoryDTO.getCivilStatus())
                .occupation(medicalHistoryDTO.getOccupation())
                .street(medicalHistoryDTO.getStreet())
                .city(medicalHistoryDTO.getCity())
                .province(medicalHistoryDTO.getProvince())
                .postalCode(medicalHistoryDTO.getPostalCode())
                .country(medicalHistoryDTO.getCountry())
                .emergencyContactFirstName(medicalHistoryDTO.getEmergencyContactFirstName())
                .emergencyContactLastName(medicalHistoryDTO.getEmergencyContactLastName())
                .emergencyContactRelationship(medicalHistoryDTO.getEmergencyContactRelationship())
                .emergencyContactPhoneNumber(medicalHistoryDTO.getEmergencyContactPhoneNumber())
                .previousIllnesses(medicalHistoryDTO.getPreviousIllnesses())
                .surgeries(medicalHistoryDTO.getSurgeries())
                .allergies(medicalHistoryDTO.getAllergies())
                .hospitalizations(medicalHistoryDTO.getHospitalizations())
                .currentMedication(medicalHistoryDTO.getCurrentMedication())
                .alcoholConsumption(medicalHistoryDTO.getAlcoholConsumption())
                .tobacco(medicalHistoryDTO.getTobacco())
                .drugs(medicalHistoryDTO.getDrugs())
                .diet(medicalHistoryDTO.getDiet())
                .exercise(medicalHistoryDTO.getExercise())
                .symptoms(medicalHistoryDTO.getSymptoms())
                .bloodPressure(medicalHistoryDTO.getBloodPressure())
                .heartRate(medicalHistoryDTO.getHeartRate())
                .temperature(medicalHistoryDTO.getTemperature())
                .breathingFrequency(medicalHistoryDTO.getBreathingFrequency())
                .diagnosis(medicalHistoryDTO.getDiagnosis())
                .carePlan(medicalHistoryDTO.getCarePlan())
                .doctorsNotes(medicalHistoryDTO.getDoctorsNotes())
                .build();
    }

    @Override
    public MedicalHistoryDTO medicalHistoryToMedicalHistoryDTO(MedicalHistory medicalHistory) {
        return MedicalHistoryDTO.builder()
                .dateOfElaboration(medicalHistory.getDateOfElaboration())
                .age(medicalHistory.getAge())
                .gender(medicalHistory.getGender())
                .nationality(medicalHistory.getNationality())
                .civilStatus(medicalHistory.getCivilStatus())
                .occupation(medicalHistory.getOccupation())
                .street(medicalHistory.getStreet())
                .city(medicalHistory.getCity())
                .province(medicalHistory.getProvince())
                .postalCode(medicalHistory.getPostalCode())
                .country(medicalHistory.getCountry())
                .emergencyContactFirstName(medicalHistory.getEmergencyContactFirstName())
                .emergencyContactLastName(medicalHistory.getEmergencyContactLastName())
                .emergencyContactRelationship(medicalHistory.getEmergencyContactRelationship())
                .emergencyContactPhoneNumber(medicalHistory.getEmergencyContactPhoneNumber())
                .previousIllnesses(medicalHistory.getPreviousIllnesses())
                .surgeries(medicalHistory.getSurgeries())
                .allergies(medicalHistory.getAllergies())
                .hospitalizations(medicalHistory.getHospitalizations())
                .currentMedication(medicalHistory.getCurrentMedication())
                .alcoholConsumption(medicalHistory.getAlcoholConsumption())
                .tobacco(medicalHistory.getTobacco())
                .drugs(medicalHistory.getDrugs())
                .diet(medicalHistory.getDiet())
                .exercise(medicalHistory.getExercise())
                .symptoms(medicalHistory.getSymptoms())
                .bloodPressure(medicalHistory.getBloodPressure())
                .heartRate(medicalHistory.getHeartRate())
                .temperature(medicalHistory.getTemperature())
                .breathingFrequency(medicalHistory.getBreathingFrequency())
                .diagnosis(medicalHistory.getDiagnosis())
                .carePlan(medicalHistory.getCarePlan())
                .doctorsNotes(medicalHistory.getDoctorsNotes())
                .build();
    }
}