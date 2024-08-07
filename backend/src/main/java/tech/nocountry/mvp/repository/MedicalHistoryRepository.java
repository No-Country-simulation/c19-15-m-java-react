package tech.nocountry.mvp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.nocountry.mvp.domain.MedicalHistory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, UUID> {
    Optional<MedicalHistory> findById(UUID medicalHistoryId);
}