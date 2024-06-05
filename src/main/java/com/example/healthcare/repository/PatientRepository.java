package com.example.healthcare.repository;

import com.example.healthcare.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient, Long> {
    Patient findPatientByFirstName(String firstName);
    Patient findPatientByLastName(String lastName);
    Patient findPatientByEmail(String email);
    Patient findPatientByPhone(String phone);
}
