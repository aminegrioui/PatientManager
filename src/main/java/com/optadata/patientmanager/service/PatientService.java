package com.optadata.patientmanager.service;


import com.optadata.patientmanager.dto.PatientDto;
import com.optadata.patientmanager.exception.PatientAlreadyExistsException;
import com.optadata.patientmanager.exception.ResourceNotFoundException;
import com.optadata.patientmanager.model.Patient;
import com.optadata.patientmanager.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PatientService {

    private PatientRepository patientRepository;

    public  PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }


    public Patient savePatient(PatientDto patientDto) throws PatientAlreadyExistsException {
        if (patientRepository.existsByInsuranceNumber(patientDto.getInsuranceNumber())) {
            throw new PatientAlreadyExistsException("This patient with this insuranceNumber " + patientDto.getInsuranceNumber() + " is already existed !! ");
        }
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setInsuranceNumber(patientDto.getInsuranceNumber());
        patient.setHealthInsuranceName(patientDto.getHealthInsuranceName());
        patient.setExpirationDate(patientDto.getExpirationDate());
        patient.setInstitutionOfInsurance(patientDto.getInstitutionOfInsurance());
        return patientRepository.save(patient);
    }
    public Patient savePatient2(Patient patient) throws PatientAlreadyExistsException {
        if (patientRepository.existsByInsuranceNumber(patient.getInsuranceNumber())) {
            throw new PatientAlreadyExistsException("This patient with this insuranceNumber " + patient.getInsuranceNumber() + " is already existed !! ");
        }
        return patientRepository.save(patient);
    }

    public Patient getPatientById(long id) throws ResourceNotFoundException {
        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Patient with id " + id + " is not exist !!"));
    }

    public Patient updatePatient(long id, PatientDto patientDetails) throws PatientAlreadyExistsException, ResourceNotFoundException {
        if (patientRepository.existsByInsuranceNumber(patientDetails.getInsuranceNumber())) {
            throw new PatientAlreadyExistsException("This patient with this insuranceNumber " + patientDetails.getInsuranceNumber() + " is already existed !! ");
        }
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Patient with id " + id + " is not exist !!"));
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setInsuranceNumber(patientDetails.getInsuranceNumber());
        patient.setHealthInsuranceName(patientDetails.getHealthInsuranceName());
        patient.setExpirationDate(patientDetails.getExpirationDate());
        patient.setInstitutionOfInsurance(patientDetails.getInstitutionOfInsurance());
        return patientRepository.save(patient);
    }

    public ResponseEntity<Map<String, Boolean>> deletePatient(long id) throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Patient with id " + id + " is not exist !!"));
        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public Patient findPatientByInsuranceNumber(String insuranceNumber) {
        if (!patientRepository.existsByInsuranceNumber(insuranceNumber)) {
            throw new ResourceNotFoundException("The patient with this insuranceNumber " + insuranceNumber + " is not exist ");
        }
        List<Patient> patients = patientRepository.findByInsuranceNumber(insuranceNumber);
        Patient patient = patients.size() != 0 ? patients.get(0) : null;
        return patient;
    }

    public boolean existsByInsuranceNumber(String insuranceNumber) {
        return patientRepository.existsByInsuranceNumber(insuranceNumber);
    }
}
