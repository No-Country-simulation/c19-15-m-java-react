package tech.nocountry.mvp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.patient.PatientDTO;
import tech.nocountry.mvp.service.patient.PatientService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    /*CREATE*/
    @PostMapping()
    public ResponseEntity<?> newPatient(@RequestBody PatientDTO patientDTO) {
        log.info("Adding patient {}", patientDTO);
        Patient patientCreated = patientService.createPatient(patientDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/patient"+patientCreated.getPatientId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}