package tech.nocountry.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.PatientDTO;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/find-all")
    private List<PatientDTO> getAllPatients() {
        return patientService.findAllPatients();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable UUID id, @RequestBody PatientDTO patientUpdated)
            throws ChangeSetPersister.NotFoundException {
        Optional<Patient> patient = patientService.updatePatient(id, patientUpdated);

        if(patient.isEmpty()){
            throw new ChangeSetPersister.NotFoundException();
        }else {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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
