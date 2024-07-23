package tech.nocountry.mvp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.nocountry.mvp.model.dto.MedicalHistoryDTO;
import tech.nocountry.mvp.model.dto.PatientDTO;
import tech.nocountry.mvp.service.medicalHistory.MedicalHistoryService;
import tech.nocountry.mvp.service.patient.PatientService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final PatientService patientService;

    private final MedicalHistoryService medicalHistoryService;

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
}