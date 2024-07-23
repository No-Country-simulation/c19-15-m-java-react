package tech.nocountry.mvp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.nocountry.mvp.domain.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query(value = "SELECT * FROM patient WHERE email = :email", nativeQuery = true)
    Optional<Patient> findByEmail(String email);
    Optional<Patient> findById(UUID uuid);
    /*Optional<Patient> findByName(String name);*/
}