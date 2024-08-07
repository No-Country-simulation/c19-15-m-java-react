package tech.nocountry.mvp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AppointmentEmailDTO {
    private UUID appointmentId;
}