package tech.nocountry.mvp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.nocountry.mvp.domain.Appointment;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
}