package tech.nocountry.mvp.service.appointment;

import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.model.dto.AppointmentDTO;

import java.time.LocalDateTime;

@Service
public interface AppointmentService {
    Appointment createAppointment(AppointmentDTO appointmentDTO);
    boolean idDoctorAvailable(Doctor doctor, LocalDateTime appointmentDate);
}