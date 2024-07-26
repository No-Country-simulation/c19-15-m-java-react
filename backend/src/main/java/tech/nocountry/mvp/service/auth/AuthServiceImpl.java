package tech.nocountry.mvp.service.auth;

import lombok.extern.slf4j.Slf4j;
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

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private final IJWTUtilityService jwtUtilityService;

    private final UserValidation userValidation;

    public AuthServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, IJWTUtilityService jwtUtilityService, UserValidation userValidation) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.jwtUtilityService = jwtUtilityService;
        this.userValidation = userValidation;
    }

    @Override
    public ResponseDTO register(Patient patient) throws Exception {
        ResponseDTO response = new ResponseDTO();
        try {
            response = userValidation.validate(patient);
            if (response.getMessages() != null){
                return response;
            }
            Optional<Patient> existingPatient = patientRepository.findByEmail(patient.getEmail());
            if (existingPatient.isPresent()) {
                response.addMessage("El usuario ya existe.");
                return response;
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            patient.setPassword(encoder.encode(patient.getPassword()));
            patient.setRole(Role.USER);
            patientRepository.save(patient);
            response.addMessage("Usuario registrado con éxito.");

        } catch (Exception e){
            response.addMessage("Error en el registro: "+e.getMessage());
        }
        return response;

    }

    @Override
    public ResponseDTO login(LoginDTO login) throws Exception {
        try {
            ResponseDTO response = new ResponseDTO();
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
                        response.addMessage("Contraseña doctor inválida");
                    }
                } else {
                    response.addMessage("Correo electrónico o contraseña inválidos");
                }
            }

            return response;
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }
    
    private boolean verifyPassword(String password, String passwordConfirmation) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, passwordConfirmation);
    }
}