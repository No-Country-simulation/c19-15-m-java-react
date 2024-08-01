package tech.nocountry.mvp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.nocountry.mvp.domain.Patient;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @Query(value = "SELECT * FROM patient WHERE email = :email", nativeQuery = true)
    Optional<Patient> findByEmail(String email);
}