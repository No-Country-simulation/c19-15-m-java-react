package tech.nocountry.mvp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.model.dto.DoctorDTO;
import tech.nocountry.mvp.model.dto.MedicalHistoryDTO;
import tech.nocountry.mvp.model.dto.PatientDTO;
import tech.nocountry.mvp.service.doctor.DoctorService;
import tech.nocountry.mvp.service.medicalHistory.MedicalHistoryService;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final PatientService patientService;

    private final MedicalHistoryService medicalHistoryService;

    private final DoctorService doctorService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") UUID id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @PutMapping("/patient/medical-history/{id}")
    public ResponseEntity<MedicalHistoryDTO> updateMedicalHistory(@PathVariable UUID id, @RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        return medicalHistoryService.updateMedicalHistoryDTO(id, medicalHistoryDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable UUID id, @RequestBody DoctorDTO doctorUpdated)
            throws ChangeSetPersister.NotFoundException {
        Optional<Doctor> doctor = doctorService.updateDoctor(id, doctorUpdated);
        if(doctor.isEmpty()){
            throw new ChangeSetPersister.NotFoundException();
        }else {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}