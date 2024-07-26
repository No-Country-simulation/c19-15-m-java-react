package tech.nocountry.mvp.service.appointment;

import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.model.dto.AppointmentDTO;
import tech.nocountry.mvp.repository.AppointmentRepository;
import tech.nocountry.mvp.repository.DoctorRepository;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.email.EmailService;

import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final EmailService emailService;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, EmailService emailService) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.emailService = emailService;
    }

    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(UUID.randomUUID());
        appointment.setPatient(patientRepository.findById(appointmentDTO.getPatientId()).orElseThrow());
        appointment.setDoctor(doctorRepository.findById(appointmentDTO.getDoctorId()).orElseThrow());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setMeetingLink(appointmentDTO.getMeetingLink());

        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Enviar correo electrónico con el enlace de la reunión
        String subject = "Detalles de la cita médica";
        String text = "Estimado " + savedAppointment.getPatient().getFirstName() + ",\n\n" +
                "Su cita médica está programada para " + savedAppointment.getAppointmentDate() + ".\n" +
                "Puede unirse a la reunión virtual usando el siguiente enlace: " + savedAppointment.getMeetingLink() + "\n\n" +
                "Saludos,\n" +
                "Equipo Médico";
        emailService.sendSimpleMessage(savedAppointment.getPatient().getEmail(), subject, text);

        return savedAppointment;
    }
}
