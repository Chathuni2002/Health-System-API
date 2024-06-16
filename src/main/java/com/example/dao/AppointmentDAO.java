/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

//import com.example.model.Person;
import com.example.model.Appointment;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class AppointmentDAO {
    
    // Map to store appointments with their IDs
    private static Map<Integer, Appointment> appointments = new HashMap<>();
    
    
    // Method to get all appointments
    public Collection<Appointment> getAllAppointments(){
        return appointments.values();
    } 
    
    // Method to get a appointment by ID
    public Appointment getAppointmentById(int id){
        return appointments.get(id);
    } 
    
    // Method to add a new appointment
    public String addAppointment(Appointment newAppointment) { 
        // Generate a new ID for the appointment
        int newId = getNextUserId(); 
        appointments.put(newId, newAppointment); 
        
        return "Appointment with ID " + newId + " created successfully.";
    }

    // Method to update an existing appointment
    public String updateAppointment(int id, Appointment updatedAppointment) {
 
        if(appointments.containsKey(id)){ 
            appointments.replace(id, updatedAppointment);
            return "Appointment with ID " + id + " updated successfully.";
        }else{
            return "Appointment with ID " + id + " not found. Cannot update.";
        }
    }

    // Method to delete a appointment by ID
    public String deleteAppointment(int id) { 
        if (appointments.containsKey(id)) {
            // Remove the user with the given ID
            appointments.remove(id);
            return "Person with ID " + id + " deleted successfully.";
        } else {
            return "Person with ID " + id + " not found. Cannot delete.";
        }
    }
    
    // Method to get the next available user ID
    public int getNextUserId() {
       // Find the maximum existing user ID
        int maxUserId = 0;
        for (int existingUserId : appointments.keySet()) {
            if (existingUserId > maxUserId) {
                maxUserId = existingUserId;
            }
        }

        // Increment to get the next available user ID
        return maxUserId + 1;
    }
}
