package tech.nocountry.mvp.mapper.medicalHistory;

import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.model.dto.MedicalHistoryDTO;

public interface MedicalHistoryMapper {

    MedicalHistory medicalHistoryDTOToMedicalHistory(MedicalHistoryDTO medicalHistoryDTO);

    MedicalHistoryDTO medicalHistoryToMedicalHistoryDTO(MedicalHistory medicalHistory);
}