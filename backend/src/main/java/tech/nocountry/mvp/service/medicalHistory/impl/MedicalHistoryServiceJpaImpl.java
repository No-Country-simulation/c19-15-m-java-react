package tech.nocountry.mvp.service.medicalHistory.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.mapper.medicalHistory.MedicalHistoryMapper;
import tech.nocountry.mvp.model.dto.medicalHistory.MedicalHistoryDTO;
import tech.nocountry.mvp.repository.MedicalHistoryRepository;
import tech.nocountry.mvp.service.medicalHistory.MedicalHistoryService;

import java.util.Optional;

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
    public boolean deleteMedicalHistory(UUID medicalHistoryId) {
        return false;
    }

    @Override
    public Optional<MedicalHistory> updateMedicalHistory(UUID medicalHistoryId, MedicalHistoryDTO medicalHistoryDTO) {
        return Optional.empty();
    }
}