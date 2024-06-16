/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Patient;
import java.util.Collection;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class PatientDAO extends PersonDAO{ 

    // Map to store patients with their IDs
    public static Map<Integer, Patient> patients = new HashMap<>();
    
    
    // Method to get all patients
    public Collection<Patient> getAllPatients(){
        return patients.values();
    } 
    
    // Method to get a patient by ID
    public Patient getPatientById(int id){
        return patients.get(id);
    } 
    
    // Method to add a new patient
    public String addPatient(Patient newPatient) { 
        // Generate a new ID for the patient
        int newId = getNextUserId(); 
        patients.put(newId, newPatient); 

        return "Patient with ID " + newId + " created successfully."; 
    }

    // Method to update an existing patient
    public String updatePatient(int id, Patient updatedPatient) {

        if(patients.containsKey(id)){ 
            patients.replace(id, updatedPatient);
            return "Patient with ID " + id + " updated successfully.";
        }else{
            return "Patient with ID " + id + " not found. Cannot update.";
        }
        
    }

    // Method to delete a patient by ID
    public String deletePatient(int id) {
        if (patients.containsKey(id)) {
            // Remove the user with the given ID
            patients.remove(id);
            return "Patient with ID " + id + " deleted successfully.";
        } else {
            return "Patient with ID " + id + " not found. Cannot delete.";
        }
    }
    
    // Method to get the next available user ID
    public int getNextUserId() {
       // Find the maximum existing user ID
        int maxUserId = 0;
        for (int existingUserId : patients.keySet()) {
            if (existingUserId > maxUserId) {
                maxUserId = existingUserId;
            }
        }

        // Increment to get the next available user ID
        return maxUserId + 1;
    }
}
