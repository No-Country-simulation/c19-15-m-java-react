package tech.nocountry.mvp.domain;

import tech.nocountry.mvp.domain.enums.Gender;

import java.util.Date;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private Address address;
    private String phone;
    private String email;
    private MedicalHistory medicalHistory;
}