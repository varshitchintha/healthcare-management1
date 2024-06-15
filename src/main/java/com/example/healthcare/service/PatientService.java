package com.example.healthcare.service;

import com.example.healthcare.models.Doctor;
import com.example.healthcare.models.Patient;
import com.example.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository = patientRepository;
    }
    public List<Patient> getDoctorByFirstName(String firstName){
        return patientRepository.findPatientByFirstName(firstName);
    }
    public List<Patient> getDoctorByLastName(String lastName){
         return patientRepository.findPatientByLastName(lastName);
    }
    public ResponseEntity<String> receiveData(Patient patient){
        try {
            if (patient.getFirstName() == null || patient.getFirstName().isEmpty()) {
                return ResponseEntity.badRequest().body("First Name is missing");
            }
            if (patient.getLastName() == null || patient.getLastName().isEmpty()) {
                return ResponseEntity.badRequest().body("Last Name is missing");
            }
            if(patient.getAge()== null || patient.getLastName().isEmpty()) {
                return ResponseEntity.badRequest().body("Age is missing");
            }
            if (patient.getGender() == null || patient.getLastName().isEmpty()) {
                return ResponseEntity.badRequest().body("Gender is missing");
            }
            Patient newPatient = patientRepository.save(patient);
            return  ResponseEntity.ok().body("Patient data has been received");
        }
        catch (Exception e){
            e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some fields are missing");
        }
    }
    public void DeletePatient(Long id){
        patientRepository.deleteById(id);
    }
    public Patient getUpdatedData(Long id, Patient patient){
        Patient existingPatient = patientRepository.findById(id).get();
        if(patient.getFirstName()!=null){
            existingPatient.setFirstName(patient.getFirstName());
        }
        if(patient.getLastName()!=null){
            existingPatient.setLastName(patient.getLastName());
        }
        if(patient.getAddress()!=null){
            existingPatient.setAddress(patient.getAddress());
        }
        if (patient.getAge()!=null){
            existingPatient.setAge(patient.getAge());
        }
        if (patient.getGender()!=null){
            existingPatient.setGender(patient.getGender());
        }
        return patientRepository.save(existingPatient);
    }
}