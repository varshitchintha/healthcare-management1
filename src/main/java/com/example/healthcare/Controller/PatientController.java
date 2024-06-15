package com.example.healthcare.Controller;

import com.example.healthcare.models.Patient;
import com.example.healthcare.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patients")

public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService){

        this.patientService = patientService;
    }
    @GetMapping("/api/patient/retrieve/firstname/{firstName}")
    public List<Patient> retrieveByFirstName(@PathVariable String firstName){
        return patientService.getDoctorByFirstName(firstName);
    }
    @GetMapping("/api/patient/retrieve/lastname/{lastName}")
    public List<Patient> retrieveByLastName(@PathVariable String lastName){
        return patientService.getDoctorByLastName(lastName);
    }
    @PostMapping("/api/patient/create")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient){
        return patientService.receiveData(patient);
    }
    @DeleteMapping("/api/doctor/delete/{id}")
    public void deleteDoctor(@PathVariable Long id){
         patientService.DeletePatient(id);
    }
    @PutMapping("/api/patient/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        return patientService.getUpdatedData(id,patient);
    }
}