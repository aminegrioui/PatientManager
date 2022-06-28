package com.optadata.patientmanager.model;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String insuranceNumber;
    private String healthInsuranceName;
    private long institutionOfInsurance;

    private LocalDate expirationDate;

    public Patient() {

    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getInsuranceNumber() {
        return this.insuranceNumber;
    }

    public String getHealthInsuranceName() {
        return this.healthInsuranceName;
    }

    public long getInstitutionOfInsurance() {
        return this.institutionOfInsurance;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setHealthInsuranceName(String healthInsuranceName) {
        this.healthInsuranceName = healthInsuranceName;
    }

    public void setInstitutionOfInsurance(long institutionOfInsurance) {
        this.institutionOfInsurance = institutionOfInsurance;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}
