/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template 
 */
package com.example.model;


/**
 *
 * @author HP
 */
public class Appointment { 
    private int appointmentNo;
    private Patient patient;
    private Doctor doctor;
    private String dateTime; 
    
    public Appointment(){
        
    } 
    
    public Appointment(int appointmentNo, Patient patient, Doctor doctor, String dateTime){
        this.appointmentNo = appointmentNo;
        this.patient = patient; 
        this.doctor = doctor; 
        this.dateTime = dateTime;
    } 

    public int getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(int appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    
}
