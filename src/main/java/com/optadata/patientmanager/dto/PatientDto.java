package com.optadata.patientmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.optadata.patientmanager.exception.MyJsonDateDeserializer;
import com.optadata.patientmanager.validations.IkValidation;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;


public class PatientDto implements Serializable {
    private long id;
    @NotEmpty
    @Size(min = 3, message = "FirstName should be at least 3 chars")
    private String firstName;
    @NotEmpty
    @Size(min = 3, message = "LastName should be at least 3 chars")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = MyJsonDateDeserializer.class)
    @PastOrPresent(message = "Date of birth must be in past or present")
    private LocalDate dateOfBirth;
    @NotEmpty
    @Size(min = 10, max = 10, message = "InsuranceNumber must have 10 digit")
    private String insuranceNumber;
    @NotEmpty
    private String healthInsuranceName;
    @IkValidation
    private long institutionOfInsurance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = MyJsonDateDeserializer.class)
    @Future(message = "Expiration date must be in future")
    private LocalDate expirationDate;

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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
