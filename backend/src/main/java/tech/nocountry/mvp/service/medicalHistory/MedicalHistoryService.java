package tech.nocountry.mvp.service.medicalHistory;

import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.model.dto.MedicalHistoryDTO;

import java.util.Optional;
import java.util.UUID;

public interface MedicalHistoryService {
    MedicalHistory createMedicalHistory(MedicalHistoryDTO medicalHistoryDTO);
    Optional<MedicalHistoryDTO> updateMedicalHistoryDTO(UUID medicalHistoryId, MedicalHistoryDTO medicalHistoryDTO);
}