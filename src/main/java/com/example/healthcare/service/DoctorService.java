package com.example.healthcare.service;
import com.example.healthcare.models.Doctor;
import com.example.healthcare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.print.Doc;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctorsByFirstName(String firstName) {
        return doctorRepository.findDoctorByFirstName(firstName);
    }

    public List<Doctor> getDoCtorByLastName(String lastName)
    {
        return doctorRepository.findDoctorByLastName(lastName);
    }


    public ResponseEntity<String> receiveData(Doctor doctor) {
        try {
            if (doctor.getFirstName() == null || doctor.getFirstName().isEmpty()) {
                return ResponseEntity.badRequest().body("First name is missing");
            }
            if (doctor.getLastName() == null || doctor.getLastName().isEmpty()) {
                return ResponseEntity.badRequest().body("Last name is missing");
            }
            if (doctor.getSpecialization() == null || doctor.getSpecialization().isEmpty()) {
                return ResponseEntity.badRequest().body("Specialization is missing");
            }
            Doctor newDoctor = doctorRepository.save(doctor);
            return ResponseEntity.ok("Doctor data is recived successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ONE OF THE REQUIRED FIELD IS MISSING");
        }
    }

    public Doctor getUpdatedData(Long id,Doctor doctor) {
       Doctor existingDoctor = doctorRepository.findById(id).get();
       if(doctor.getFirstName()!=null){
           existingDoctor.setFirstName(doctor.getFirstName());
       }
       if(doctor.getLastName()!=null){
           existingDoctor.setLastName(doctor.getLastName());
       }
       if(doctor.getSpecialization()!=null){
           existingDoctor.setSpecialization(doctor.getSpecialization());
       }
       doctorRepository.save(existingDoctor);
       return existingDoctor;
    }
    public void deleteDoctor(Long id) {
      doctorRepository.deleteById(id);
    }
}