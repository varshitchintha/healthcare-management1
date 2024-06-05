package com.example.healthcare.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;

    protected Doctor() {
        // Default constructor required by JPA
    }
    public Doctor(String firstName, String lastName, String specialization, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + this.id +
                ", first name='" + this.firstName + '\'' +
                ", last name='" + this.lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';

    }
}
