package com.optadata.patientmanager.repository;


import com.optadata.patientmanager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
     List<Patient> findByInsuranceNumber(String insuranceNumber);
     boolean existsByInsuranceNumber(String insuranceNumber);
}
