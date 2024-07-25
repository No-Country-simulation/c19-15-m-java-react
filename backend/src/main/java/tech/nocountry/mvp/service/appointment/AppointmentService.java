package tech.nocountry.mvp.service.appointment;

import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.model.dto.AppointmentDTO;

public interface AppointmentService {
    public Appointment createAppointment(AppointmentDTO appointmentDTO);
}