package tech.nocountry.mvp.service.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.mapper.doctor.DoctorMapper;
import tech.nocountry.mvp.model.dto.DoctorDTO;
import tech.nocountry.mvp.repository.DoctorRepository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DoctorServiceJpaImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    @Override
    public Optional<Doctor> updateDoctor(UUID doctorId, DoctorDTO doctorDTO) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctorMapper.doctorDTOToDoctor(doctorDTO, doctor);
            doctorRepository.save(doctor);
        }
        return doctorOptional;
    }
}