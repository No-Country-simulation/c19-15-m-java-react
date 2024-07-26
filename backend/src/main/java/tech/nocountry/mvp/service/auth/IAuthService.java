package tech.nocountry.mvp.service.auth;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.LoginDTO;
import tech.nocountry.mvp.model.dto.ResponseDTO;

public interface IAuthService {
    ResponseDTO register(Patient patient);
    ResponseDTO login(LoginDTO login);
    ResponseDTO logout(String token);
}
