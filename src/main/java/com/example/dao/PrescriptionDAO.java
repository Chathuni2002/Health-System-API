/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Prescription;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class PrescriptionDAO {
    
    // Map to store prescriptions with their IDs
    private static Map<Integer, Prescription> prescriptions = new HashMap<>();
    
    
    // Method to get all prescriptions
    public Collection<Prescription> getAllPrescriptions(){
        return prescriptions.values();
    } 
    
    // Method to get a prescription by ID
    public Prescription getPrescriptionById(int id){
        return prescriptions.get(id);
    } 
    
    // Method to add a new prescription
    public String addPrescription(Prescription newPrescription) { 
        // Generate a new ID for the prescription
        int newId = getNextUserId(); 
        prescriptions.put(newId, newPrescription); 
        
        return "Prescription with ID " + newId + " created successfully.";
    }

    // Method to update an existing prescription
    public String updatePrescription(int id, Prescription updatedPrescription) {

        if(prescriptions.containsKey(id)){ 
            prescriptions.replace(id, updatedPrescription);

            return "Prescription with ID " + id + " updated successfully.";
        }else{
            return "Prescription with ID " + id + " not found. Cannot update.";
        }
    }

    // Method to delete a prescription by ID
    public String deletePrescription(int id) { 
        if (prescriptions.containsKey(id)) {
            // Remove the user with the given ID
            prescriptions.remove(id);
            return "Prescription with ID " + id + " deleted successfully.";
        } else {
            return "Prescription with ID " + id + " not found. Cannot delete.";
        }
    }
    
    // Method to get the next available user ID
    public int getNextUserId() {
       // Find the maximum existing user ID
        int maxUserId = 0;
        for (int existingUserId : prescriptions.keySet()) {
            if (existingUserId > maxUserId) {
                maxUserId = existingUserId;
            }
        }

        // Increment to get the next available user ID
        return maxUserId + 1;
    }
}
