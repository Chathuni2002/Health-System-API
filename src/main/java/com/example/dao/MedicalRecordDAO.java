/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class MedicalRecordDAO {
    
    // List to store medical records with their IDs
    private static List<MedicalRecord> medicalRecords = new ArrayList<>(); 
    
    // Method to get all medical records
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    // Method to get a medical record by ID
    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord;
            }
        }
        return null;
    }

    // Method to add a new medical record
    public String addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord); 
        return "Medical record is created successfully.";
    }

    // Method to update an existing medical record
    public String updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord medicalRecord = medicalRecords.get(i);
            if (medicalRecord.getPatientId() == updatedMedicalRecord.getPatientId()) {
                medicalRecords.set(i, updatedMedicalRecord);
                System.out.println("MedicalRecord updated: " + updatedMedicalRecord);
                
            }
        } 
        return "Medical record is updated successfully.";
    }

    // Method to delete a medical record by ID
    public String deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getPatientId() == id); 
        return "Medical record is deleted successfully.";
    }

}
