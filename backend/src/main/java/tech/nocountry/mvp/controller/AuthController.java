package tech.nocountry.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.LoginDTO;
import tech.nocountry.mvp.model.dto.ResponseDTO;
import tech.nocountry.mvp.service.auth.IAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    private ResponseEntity<ResponseDTO> register(@RequestBody Patient patient) throws Exception {
        return new ResponseEntity<>(authService.register(patient), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login) {
        try {
            ResponseDTO response = authService.login(login);
            if (response.getMessages() != null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO());
        }
    }

}