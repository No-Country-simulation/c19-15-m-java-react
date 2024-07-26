package tech.nocountry.mvp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.model.dto.AppointmentDTO;
import tech.nocountry.mvp.service.appointment.AppointmentService;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentService.createAppointment(appointmentDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/appointments"+ appointment.getAppointmentId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}