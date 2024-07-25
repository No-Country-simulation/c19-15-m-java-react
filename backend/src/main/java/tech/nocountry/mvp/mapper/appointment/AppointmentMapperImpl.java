package tech.nocountry.mvp.mapper.appointment;

import org.springframework.stereotype.Component;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.model.dto.AppointmentDTO;

@Component
public class AppointmentMapperImpl implements AppointmentMapper {
    @Override
    public AppointmentDTO appointmentToAppointmentDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setPatientId(appointment.getPatient().getPatientId());
        dto.setDoctorId(appointment.getDoctor().getDoctorId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setStatus(appointment.getStatus());
        dto.setMeetingLink(appointment.getMeetingLink());
        return dto;
    }

    @Override
    public Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setMeetingLink(appointmentDTO.getMeetingLink());
        return appointment;
    }
}