package tech.nocountry.mvp.service.appointment;

import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Appointment;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.model.dto.AppointmentDTO;
import tech.nocountry.mvp.repository.AppointmentRepository;
import tech.nocountry.mvp.repository.DoctorRepository;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.email.EmailService;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.List;

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
        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor no encontrado"));

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(UUID.randomUUID());
        appointment.setDoctor(doctor);
        appointment.setPatient(patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado")));
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setMeetingLink(appointmentDTO.getMeetingLink());

        return appointmentRepository.save(appointment);
    }

    @Override
    public boolean idDoctorAvailable(Doctor doctor, LocalDateTime appointmentDate) {
        // Verificar si la cita está dentro del horario de atención del médico
        if (!isWithinOfficeHours(doctor.getOfficeHours(), appointmentDate)) {
            return false;
        }

        // Verificar si hay otras citas en la misma fecha y hora
        LocalDateTime startOfAppointment = appointmentDate;
        LocalDateTime endOfAppointment = appointmentDate.plusHours(1); // Suponemos que cada cita dura 1 hora

        List<Appointment> appointments = appointmentRepository.findByDoctorAndAppointmentDateBetween(doctor, startOfAppointment, endOfAppointment);
        return appointments.isEmpty();
    }

    private boolean isWithinOfficeHours(String officeHours, LocalDateTime appointmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E h:mma");
        // Obtener el día de la semana de la fecha de la cita
        DayOfWeek dayOfWeek = appointmentDate.getDayOfWeek();
        String dayStr = dayOfWeek.toString().substring(0, 3).toUpperCase();

        // Dividir las horas de oficina en partes
        String[] officeHoursParts = officeHours.split(" ");
        String[] dayRange = officeHoursParts[0].split("-");

        String startDay = dayRange[0].toUpperCase();
        String endDay = dayRange[1].toUpperCase();

        String[] startEndHours = officeHoursParts[1].split("-");
        String startHour = startEndHours[0];
        String endHour = startEndHours[1];

        // Verificar si el día de la cita está dentro del rango de días de atención
        if (dayStr.compareTo(startDay) < 0 || dayStr.compareTo(endDay) > 0) {
            return false;
        }

        // Verificar si la hora de la cita está dentro del rango de horas de atención
        LocalDateTime startOfOfficeHours = appointmentDate.withHour(parseHour(startHour)).withMinute(0);
        LocalDateTime endOfOfficeHours = appointmentDate.withHour(parseHour(endHour)).withMinute(0);

        return !appointmentDate.isBefore(startOfOfficeHours) && !appointmentDate.isAfter(endOfOfficeHours);
    }

    private int parseHour(String time) {
        // Convertir "9am" a 9 y "5pm" a 17
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
        return LocalDateTime.parse(time.toUpperCase(), formatter).getHour();
    }
}