package tech.nocountry.mvp.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.enumeration.Role;
import tech.nocountry.mvp.model.dto.LoginDTO;
import tech.nocountry.mvp.model.dto.ResponseDTO;
import tech.nocountry.mvp.model.validation.UserValidation;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.jwtSecurity.IJWTUtilityService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    private final PatientRepository patientRepository;

    private final IJWTUtilityService jwtUtilityService;

    private final UserValidation userValidation;

    public AuthServiceImpl(PatientRepository patientRepository, IJWTUtilityService jwtUtilityService, UserValidation userValidation) {
        this.patientRepository = patientRepository;
        this.jwtUtilityService = jwtUtilityService;
        this.userValidation = userValidation;
    }

    @Override
    public ResponseDTO login(LoginDTO login) throws Exception {
        try {
            ResponseDTO response = new ResponseDTO();
            Optional<Patient> patient = patientRepository.findByEmail(login.getEmail());

            if (patient.isEmpty()) {
                response.setMessage("Invalid email or password");
                return response;
            }

            if (verifyPassword(login.getPassword(), patient.get().getPassword())) {
                response.setJwt(jwtUtilityService.generateJWT(patient.get().getPatientId()));
            } else {
                response.setMessage("Invalid password");
            }
            return response;
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public ResponseDTO register(Patient patient) throws Exception {
        try {
            ResponseDTO responseDTO = userValidation.validate(patient);
            List<Patient> getAllPatients = patientRepository.findAll();
            for (Patient repeatField : getAllPatients) {
                if (repeatField.getEmail().equals(patient.getEmail())) {
                    responseDTO.setMessage("User already exists");
                    return responseDTO;
                }
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            patient.setPassword(encoder.encode(patient.getPassword()));
            patient.setRole(Role.USER);
            patientRepository.save(patient);
            responseDTO.setMessage("User registered successfully");
            return responseDTO;
        } catch (Exception e){
            throw new Exception(e.toString());
        }
    }
    private boolean verifyPassword(String password, String passwordConfirmation) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, passwordConfirmation);
    }
}