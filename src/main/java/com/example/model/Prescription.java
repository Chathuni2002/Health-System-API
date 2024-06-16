/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author HP
 */
public class Prescription {
    private int prescriptionId;
    private int patientId; 
    private int doctorId;
    private String medication;
    private String dosage;
    private String instructions;
    private String duration; 
    
    public Prescription(){
        
    }
    public Prescription(int prescriptionId, int patientId, int doctorId, String medication, String dosage, String instructions, String duration) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId; 
        this.doctorId = doctorId;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    } 

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    } 

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
