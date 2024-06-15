package com.example.healthcare.repository;
import java.util.List;
import com.example.healthcare.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient, Long> {
   List<Patient> findPatientByFirstName(String firstName);
    List<Patient> findPatientByLastName(String lastName);
}
