package com.optadata.patientmanager.controller;


import com.optadata.patientmanager.dto.PatientDto;
import com.optadata.patientmanager.model.Patient;
import com.optadata.patientmanager.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/allPatients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatient();
    }
    @PostMapping("/postPatient")
    public ResponseEntity<Patient> savePatient(@Valid @RequestBody PatientDto patientDto){
        Patient patient=  patientService.savePatient(patientDto);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable long patientId){
        return patientService.getPatientById(patientId);

    }
    @PutMapping ("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable long patientId,@Valid @RequestBody PatientDto patientDto){
        Patient patient= patientService.updatePatient(patientId,patientDto);
        return new ResponseEntity<>(patient, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{patientId}")
    public ResponseEntity<Map<String, Boolean>> deletePatientById(@PathVariable long patientId){
        return patientService.deletePatient(patientId);
    }
    @GetMapping("/get/{insuranceNumber}")
    public ResponseEntity<PatientDto> getPatientByInsuranceNumber(@PathVariable String insuranceNumber){
        return patientService.findPatientByInsuranceNumber(insuranceNumber);
    }
    @GetMapping("/get/exist/{insuranceNumber}")
    public boolean existsByInsuranceNumber(@PathVariable String insuranceNumber){
        return patientService.existsByInsuranceNumber(insuranceNumber);
    }
}
