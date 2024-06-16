/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;


/**
 *
 * @author HP
 */
public class MedicalRecord {
    private int patientId;
    private String diagnoses;
    private String treatments;
    private String labResults;
    private String notes; 
    
    public MedicalRecord(){
        
    }
    
    public MedicalRecord(int patientId, String diagnoses, String treatments, String labResults, String notes){
        this.patientId = patientId; 
        this.diagnoses = diagnoses; 
        this.treatments = treatments; 
        this.labResults = labResults; 
        this.notes = notes;
    } 

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getLabResults() {
        return labResults;
    }

    public void setLabResults(String labResults) {
        this.labResults = labResults;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
}
