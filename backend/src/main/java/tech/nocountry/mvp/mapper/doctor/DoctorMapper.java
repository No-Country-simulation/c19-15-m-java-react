package tech.nocountry.mvp.mapper.doctor;

import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.model.dto.DoctorDTO;

public interface DoctorMapper {
    DoctorDTO doctorToDoctorDTO(Doctor doctor);
    Doctor doctorDTOToDoctor(DoctorDTO doctorDTO);
    Doctor doctorDTOToDoctor(DoctorDTO doctorDTO, Doctor doctor);
}