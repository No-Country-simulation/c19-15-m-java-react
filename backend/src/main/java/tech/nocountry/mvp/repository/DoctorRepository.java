package tech.nocountry.mvp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.nocountry.mvp.domain.Doctor;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    @Query(value = "SELECT * FROM doctor WHERE email = :email", nativeQuery = true)
    Optional<Doctor> findByEmail(String email);
   /* Optional<Doctor> findById(UUID uuid);*/
}