package tech.nocountry.mvp.service.doctor;

import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.model.dto.DoctorDTO;

import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    Optional<Doctor> updateDoctor(UUID doctorId, DoctorDTO doctorDTO);
}