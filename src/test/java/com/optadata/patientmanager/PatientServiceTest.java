package com.optadata.patientmanager;

import com.optadata.patientmanager.dto.PatientDto;
import com.optadata.patientmanager.exception.ResourceNotFoundException;
import com.optadata.patientmanager.model.Patient;
import com.optadata.patientmanager.repository.PatientRepository;
import com.optadata.patientmanager.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PatientServiceTest {
    // we have to Mock the dependencies

    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService patientService;
    private Patient mockPatient;

    @BeforeEach
    public void setUp() {
        mockPatient = new Patient();
        mockPatient.setId(25);
        mockPatient.setDateOfBirth(LocalDate.of(1975, 10, 10));
        mockPatient.setFirstName("Amine");
        mockPatient.setLastName("Grioui");
        mockPatient.setInsuranceNumber("L193459781");
        mockPatient.setInstitutionOfInsurance(260326822);
        mockPatient.setHealthInsuranceName("TK");
        mockPatient.setExpirationDate(LocalDate.of(2026, 10, 10));
    }

    @Test
    @DisplayName("Should Retrieve Patient by Id")
    public void test_getPatientById() throws ResourceNotFoundException {
        Mockito.when(patientRepository.findById(25l)).thenReturn(Optional.of(mockPatient));
        Patient patient = patientService.getPatientById(25);
        assertTrue(patient.getId() == 25);
        assertTrue(patient.getFirstName() == "Amine");
        assertTrue(patient.getLastName() == "Grioui");
        assertTrue(patient.getDateOfBirth().equals(LocalDate.of(1975, 10, 10)));
        assertTrue(patient.getInsuranceNumber() == "L193459781");
        assertTrue(patient.getHealthInsuranceName() == "TK");
        assertTrue(patient.getInstitutionOfInsurance() == 260326822);
        assertTrue(patient.getExpirationDate().equals(LocalDate.of(2026, 10, 10)));
    }

    @Test
    @DisplayName("Test the Exception when the given Id is not in DB")
    public void shouldFaildWhenResourceNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> patientService.getPatientById(457));
    }

    @Test
    @DisplayName("Get All Patients")
    public void testGetAllPatients() {
        List<Patient> mockPatients = new ArrayList<>();
        mockPatients.add(mockPatient);
        mockPatient.setId(3l);
        mockPatients.add(mockPatient);
        Mockito.when(patientRepository.findAll()).thenReturn(mockPatients);
        List<Patient> patients = patientService.getAllPatient();
        assertTrue(patients.size() == 2);
    }

    @Test
    @DisplayName("Update patient")
    public void testUpdatePatient() {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName("Mohammed Amine");
        Mockito.when(patientRepository.findById(25l)).thenReturn(Optional.of(mockPatient));
        Mockito.when(patientRepository.save(mockPatient)).thenReturn(mockPatient);
        Patient updatedPatient = patientService.updatePatient(25, patientDto);
        assertTrue(updatedPatient.getFirstName().equals(patientDto.getFirstName()));
    }

    @Test
    @DisplayName("Find a patient by  InsuranceNumber")
    public void testFindPatientByInsuranceNumber() {
        List<Patient> patients = new ArrayList<>();
        patients.add(mockPatient);
        Mockito.when(patientRepository.findByInsuranceNumber("L193459781")).thenReturn(patients);
        Mockito.when(patientRepository.existsByInsuranceNumber("L193459781")).thenReturn(true);
        Patient patient=patientService.findPatientByInsuranceNumber("L193459781");
        assertTrue(patient.getInsuranceNumber().equals("L193459781"));
    }
    @Test
    @DisplayName("Test the Exception when the given InsuranceNumber is not found")
    public void testFindPatientByInsuranceNumber_fiald_test() {
        Mockito.when(patientRepository.existsByInsuranceNumber("q193459781")).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> patientService.findPatientByInsuranceNumber("q193459781"));
    }
}
