package tech.nocountry.mvp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.patient.PatientDTO;
import tech.nocountry.mvp.repository.PatientRepository;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;
    private final PatientRepository patientRepository;

    /*CREATE*/
    @PostMapping("/register")
    public ResponseEntity<?> newPatient(@RequestBody PatientDTO patientDTO) {
        log.info("Adding patient {}", patientDTO);
        Patient patientCreated = patientService.createPatient(patientDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/patient"+patientCreated.getPatientId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /*UPDATE*/
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO, @PathVariable UUID id) {
        Optional<Patient> updatePatient = patientService.updatePatient(id, patientDTO);
        return updatePatient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}