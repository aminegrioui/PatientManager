package com.optadata.patientmanager.tool;


import com.optadata.patientmanager.dto.PatientDto;
import com.optadata.patientmanager.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientConverter {

    public Patient patientDtoToPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setInsuranceNumber(patientDto.getInsuranceNumber());
        patient.setHealthInsuranceName(patientDto.getHealthInsuranceName());
        patient.setExpirationDate(patientDto.getExpirationDate());
        patient.setInstitutionOfInsurance(patientDto.getInstitutionOfInsurance());
        return patient;
    }

    public PatientDto patientToPatientDto(Patient patient) {
        if (patient != null) {
            PatientDto patientDto = new PatientDto();
            patientDto.setId(patient.getId());
            patientDto.setFirstName(patient.getFirstName());
            patientDto.setLastName(patient.getLastName());
            patientDto.setDateOfBirth(patient.getDateOfBirth());
            patientDto.setInsuranceNumber(patient.getInsuranceNumber());
            patientDto.setHealthInsuranceName(patient.getHealthInsuranceName());
            patientDto.setExpirationDate(patient.getExpirationDate());
            patientDto.setInstitutionOfInsurance(patient.getInstitutionOfInsurance());
            return patientDto;
        }
        return null;

    }

    public List<PatientDto> patientListToPatientDtoList(List<Patient> patients) {
        return patients.stream().map(this::patientToPatientDto).collect(Collectors.toList());
    }
}
