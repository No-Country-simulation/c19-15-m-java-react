package tech.nocountry.mvp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.nocountry.mvp.domain.MedicalHistory;

import java.util.UUID;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, UUID> {
}