package tech.nocountry.mvp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.nocountry.mvp.domain.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}