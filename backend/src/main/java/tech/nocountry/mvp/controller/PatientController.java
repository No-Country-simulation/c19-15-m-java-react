package tech.nocountry.mvp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.PatientDTO;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/findall")
    private List<PatientDTO> getAllPatients() {
        /*return new ResponseEntity<>(patientService.findAllPatients(), HttpStatus.OK);*/
        return patientService.findAllPatients();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable UUID id, @RequestBody PatientDTO patientDTO) {
        Optional<Patient> updatedPatient = patientService.updatePatient(id, patientDTO);
        return updatedPatient.map(patient -> new ResponseEntity<>(patient, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        boolean isDeleted = patientService.deletePatient(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
