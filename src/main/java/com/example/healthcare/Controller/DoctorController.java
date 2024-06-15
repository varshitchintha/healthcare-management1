package com.example.healthcare.Controller;

import com.example.healthcare.models.Doctor;
import com.example.healthcare.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }
    @GetMapping("/api/doctor/retrieve/firstname/{firstName}")
    public List<Doctor> retrieveByFirstName(@PathVariable String firstName){
        return doctorService.getDoctorsByFirstName(firstName);
    }
    @GetMapping("/api/doctor/retrieve/lastname/{lastName}")
    public List<Doctor> retrieveByLastName(@PathVariable String lastName){
        return doctorService.getDoCtorByLastName(lastName);
    }
    @PostMapping("/api/doctor/create")
    public ResponseEntity<String> createDoctor(@RequestBody Doctor doctor){
        return doctorService.receiveData(doctor);
      }
    @PutMapping("/api/doctor/update/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable Long id){
        return doctorService.getUpdatedData(id,doctor);
    }
    @DeleteMapping("/api/doctor/delete/{id}")
    public void deleteDoctor(@PathVariable Long id){
         doctorService.deleteDoctor(id);
    }

}