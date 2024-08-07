package tech.nocountry.mvp.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class AppointmentDTO {
    private UUID appointmentId;
    private UUID patientId;
    private UUID doctorId;
    private LocalDateTime appointmentDate;
    private String status;
    private String meetingLink;
}