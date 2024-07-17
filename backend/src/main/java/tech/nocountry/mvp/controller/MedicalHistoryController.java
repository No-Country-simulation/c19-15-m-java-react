package tech.nocountry.mvp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.nocountry.mvp.domain.MedicalHistory;
import tech.nocountry.mvp.model.dto.medicalHistory.MedicalHistoryDTO;
import tech.nocountry.mvp.service.medicalHistory.MedicalHistoryService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/medical-history")
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;

    /*CREATE*/
    @PostMapping()
    public ResponseEntity<MedicalHistoryDTO> create(@RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        log.info("Creating MedicalHistory: {}", medicalHistoryDTO);
        MedicalHistory medicalHistoryCreated = medicalHistoryService.createMedicalHistory(medicalHistoryDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/medical-history"+medicalHistoryCreated.getMedicalHistoryId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}