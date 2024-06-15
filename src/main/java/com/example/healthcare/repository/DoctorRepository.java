package com.example.healthcare.repository;

import com.example.healthcare.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    public List<Doctor> findDoctorByFirstName(String firstName);
    public List<Doctor> findDoctorByLastName(String lastName);
   // public Doctor save();

    void deleteById(long id);
}
