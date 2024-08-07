package tech.nocountry.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<ResponseDTO> register(@RequestBody Patient patient) {
        ResponseDTO response = new ResponseDTO();
        try {
            response = authService.register(patient);

            if (response.getMessages().contains("Error en el registro")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            if (response.getMessages().contains("El usuario ya existe.")) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.addMessage("Error interno del servidor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login) {
        try {
            ResponseDTO response = authService.login(login);

            if (!response.getMessages().isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO errorResponse = new ResponseDTO();
            errorResponse.addMessage("Error interno del servidor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseDTO> logout(@RequestHeader("Authorization") String authorizationHeader) {
        // Extraer el token del header
        String token = authorizationHeader.substring(7); // "Bearer " -> 7 caracteres
        ResponseDTO response = authService.logout(token);
        if (response.getMessages().contains("Error durante el cierre de sesión")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.ok(response);
    }
}