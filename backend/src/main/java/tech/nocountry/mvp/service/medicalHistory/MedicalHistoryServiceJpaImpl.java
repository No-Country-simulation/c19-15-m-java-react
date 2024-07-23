package tech.nocountry.mvp.service.medicalHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.mapper.medicalHistory.MedicalHistoryMapper;
import tech.nocountry.mvp.model.dto.MedicalHistoryDTO;
import tech.nocountry.mvp.repository.MedicalHistoryRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MedicalHistoryServiceJpaImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final MedicalHistoryMapper medicalHistoryMapper;

    @Override
    public MedicalHistory createMedicalHistory(MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistory medicalHistory = medicalHistoryMapper.medicalHistoryDTOToMedicalHistory(medicalHistoryDTO);
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public Optional<MedicalHistoryDTO> updateMedicalHistoryDTO(UUID medicalHistoryId, MedicalHistoryDTO medicalHistoryDTO) {
        Optional<MedicalHistory> existingHistory = medicalHistoryRepository.findById(medicalHistoryId);
        if (existingHistory.isPresent()) {
            MedicalHistory medicalHistory = existingHistory.get();
            medicalHistory.setDateOfElaboration(medicalHistoryDTO.getDateOfElaboration());
            medicalHistory.setSymptoms(medicalHistoryDTO.getSymptoms());
            medicalHistory.setBloodPressure(medicalHistoryDTO.getBloodPressure());
            medicalHistory.setTemperature(medicalHistoryDTO.getTemperature());
            medicalHistory.setBreathingFrequency(medicalHistoryDTO.getBreathingFrequency());
            medicalHistory.setDiagnosis(medicalHistoryDTO.getDiagnosis());
            medicalHistory.setCarePlan(medicalHistoryDTO.getCarePlan());
            medicalHistory.setDoctorsNotes(medicalHistoryDTO.getDoctorsNotes());

            return Optional.of(medicalHistoryMapper.medicalHistoryToMedicalHistoryDTO(medicalHistory));
        }
        return Optional.empty();
    }
}