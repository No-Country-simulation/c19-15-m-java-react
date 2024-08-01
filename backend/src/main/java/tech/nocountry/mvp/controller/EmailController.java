package tech.nocountry.mvp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.model.dto.AppointmentEmailDTO;
import tech.nocountry.mvp.repository.AppointmentRepository;
import tech.nocountry.mvp.service.email.EmailService;

@RestController
@RequestMapping("/api/v1/emails")
public class EmailController {

    private final EmailService emailService;
    private final AppointmentRepository appointmentRepository;

    public EmailController(EmailService emailService, AppointmentRepository appointmentRepository) {
        this.emailService = emailService;
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<Void> sendEmail(@RequestBody AppointmentEmailDTO email) {
        Appointment appointment = appointmentRepository.findById(email.getAppointmentId()).orElseThrow();

        String subject = "Detalles de la cita médica";
        String text = "Estimado " + appointment.getPatient().getFirstName() + ",\n\n" +
                "Su cita médica está programada para " + appointment.getAppointmentDate() + ".\n" +
                "Puede unirse a la reunión virtual usando el siguiente enlace: " + appointment.getMeetingLink() + "\n\n" +
                "Saludos,\n" +
                "Equipo Médico";
        emailService.sendSimpleMessage(appointment.getPatient().getEmail(), subject, text);

        return ResponseEntity.ok().build();
    }
}