package tech.nocountry.mvp.service.auth;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.LoginDTO;
import tech.nocountry.mvp.model.dto.ResponseDTO;

public interface IAuthService {
    public ResponseDTO register(Patient patient) throws Exception;
    public ResponseDTO login(LoginDTO login) throws Exception;
}
