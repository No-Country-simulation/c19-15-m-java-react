package tech.nocountry.mvp.service.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.enumeration.Role;
import tech.nocountry.mvp.model.dto.LoginDTO;
import tech.nocountry.mvp.model.dto.ResponseDTO;
import tech.nocountry.mvp.model.validation.UserValidation;
import tech.nocountry.mvp.repository.DoctorRepository;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.jwtSecurity.IJWTUtilityService;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private final IJWTUtilityService jwtUtilityService;

    private final UserValidation userValidation;

    private final TokenBlacklistService tokenBlacklistService;

    public AuthServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, IJWTUtilityService jwtUtilityService, UserValidation userValidation, TokenBlacklistService tokenBlacklistService) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.jwtUtilityService = jwtUtilityService;
        this.userValidation = userValidation;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @Override
    public ResponseDTO register(Patient patient) {
        ResponseDTO response = new ResponseDTO();
        try {
            // Válida al paciente y obtiene el ResponseDTO.
            response = userValidation.validate(patient);

            // Si hay mensajes, la validación falló.
            if (!response.getMessages().isEmpty()) {
                return response;
            }

            // Verifica si el paciente ya existe.
            Optional<Patient> existingPatient = patientRepository.findByEmail(patient.getEmail());
            if (existingPatient.isPresent()) {
                response.addMessage("El usuario ya existe.");
                return response;
            }

            // Codifica la contraseña y guarda el paciente.
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            patient.setPassword(encoder.encode(patient.getPassword()));
            patient.setRole(Role.USER);
            patientRepository.save(patient);

            // Añade un mensaje de éxito.
            response.addMessage("Usuario registrado con éxito.");
        } catch (Exception e) {
            response.addMessage("Error en el registro: " + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseDTO login(LoginDTO login) {
        ResponseDTO response = new ResponseDTO();

        try {
            Optional<Patient> patient = patientRepository.findByEmail(login.getEmail());
            if (patient.isPresent()) {
                if (verifyPassword(login.getPassword(), patient.get().getPassword())) {
                    response.setJwt(jwtUtilityService.generateJWT(patient.get().getPatientId()));
                } else {
                    response.addMessage("Contraseña inválida");
                }
            } else {
                Optional<Doctor> doctor = doctorRepository.findByEmail(login.getEmail());
                if (doctor.isPresent()) {
                    if (verifyPassword(login.getPassword(), doctor.get().getPassword())) {
                        response.setJwt(jwtUtilityService.generateJWT(doctor.get().getDoctorId()));
                    } else {
                        response.addMessage("Contraseña inválida");
                    }
                } else {
                    response.addMessage("Correo electrónico o contraseña inválidos");
                }
            }

        } catch (Exception e) {
            response.addMessage("Error en el proceso de autenticación: " + e.getMessage());
        }

        return response;
    }

    @Override
    public ResponseDTO logout(String token) {
        ResponseDTO response = new ResponseDTO();
        try {
            tokenBlacklistService.blacklistToken(token);

            response.addMessage("Cierre de sesión exitoso.");
        } catch (Exception e) {
            response.addMessage("Error durante el cierre de sesión: " + e.getMessage());
        }
        return response;
    }

    private boolean verifyPassword(String password, String passwordHash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, passwordHash);
    }
}