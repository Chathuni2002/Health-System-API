/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Doctor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class DoctorDAO extends PersonDAO{

    // Map to store doctors with their IDs
    public static Map<Integer, Doctor> doctors = new HashMap<>();
    
    
    // Method to get all doctors
    public Collection<Doctor> getAllDoctors(){
        return doctors.values(); 
    } 
    
    // Method to get a doctor by ID
    public Doctor getDoctorById(int id){
        return doctors.get(id);
    } 
    
    // Method to add a new doctor
    public String addDoctor(Doctor newDoctor) { 
        // Generate a new ID for the doctor
        int newId = getNextUserId(); 
        doctors.put(newId, newDoctor); 
        
        return "Doctor with ID " + newId + " created successfully."; 
    }

    // Method to update an existing doctor
    public String updateDoctor(int id, Doctor updatedDoctor) {

        if(doctors.containsKey(id)){ 
            doctors.replace(id, updatedDoctor);

            return "Doctor with ID " + id + " updated successfully.";
        }else{
            return "Doctor with ID " + id + " not found. Cannot update.";
        }

    }

    // Method to delete a doctor by ID
    public String deleteDoctor(int id) {
        if (doctors.containsKey(id)) {
            // Remove the user with the given ID
            doctors.remove(id);
            return "Doctor with ID " + id + " deleted successfully.";
        } else {
            return "Doctor with ID " + id + " not found. Cannot delete.";
        }
    }
    
    // Method to get the next available user ID
    public int getNextUserId() {
       // Find the maximum existing user ID
        int maxUserId = 0;
        for (int existingUserId : doctors.keySet()) {
            if (existingUserId > maxUserId) {
                maxUserId = existingUserId;
            }
        }

        // Increment to get the next available user ID
        return maxUserId + 1;
    }
}
