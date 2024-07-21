package tech.nocountry.mvp.service.auth;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.LoginDTO;
import tech.nocountry.mvp.model.dto.ResponseDTO;

import java.util.HashMap;

public interface IAuthService {
    /*public HashMap<String, String> login(LoginDTO login) throws Exception;*/
    public ResponseDTO register(Patient patient) throws Exception;
    public ResponseDTO login(LoginDTO login) throws Exception;
}
