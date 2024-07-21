package tech.nocountry.mvp.service.medicalHistory;

import org.hibernate.validator.constraints.UUID;
import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.model.dto.MedicalHistoryDTO;

import java.util.Optional;

public interface MedicalHistoryService {
    MedicalHistory createMedicalHistory(MedicalHistoryDTO medicalHistoryDTO);
    boolean deleteMedicalHistory(UUID medicalHistoryId);
    Optional<MedicalHistory> updateMedicalHistory(UUID medicalHistoryId, MedicalHistoryDTO medicalHistoryDTO);
}