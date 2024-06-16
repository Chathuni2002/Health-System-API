/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Billing;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class BillingDAO {
    
    // Map to store billings with their IDs
    private static Map<Integer, Billing> billings = new HashMap<>();
    
    
    // Method to get all billings
    public Collection<Billing> getAllBillings(){
        return billings.values();
    } 
    
    // Method to get a billing by ID
    public Billing getBillingById(int id){
        return billings.get(id);
    } 
    
    // Method to add a new billing
    public String addBilling(Billing newBilling) { 
        // Generate a new ID for the billing
        int newId = getNextUserId(); 
        billings.put(newId, newBilling); 
        
        return "Billing with ID " + newId + " created successfully.";
    }

    // Method to update an existing billing
    public String updateBilling(int id, Billing updatedBilling) {

        if(billings.containsKey(id)){ 
            billings.replace(id, updatedBilling);
            return "Billing with ID " + id + " updated successfully.";
        }else{
            return "Billing with ID " + id + " not found. Cannot update.";
        }
    }

    // Method to delete a billing by ID
    public String deleteBilling(int id) { 
        if (billings.containsKey(id)) {
            // Remove the user with the given ID
            billings.remove(id);
            return "Billing with ID " + id + " deleted successfully.";
        } else {
            return "Billing with ID " + id + " not found. Cannot delete.";
        }
    }
    
    // Method to get the next available user ID
    public int getNextUserId() {
       // Find the maximum existing user ID
        int maxUserId = 0;
        for (int existingUserId : billings.keySet()) {
            if (existingUserId > maxUserId) {
                maxUserId = existingUserId;
            }
        }

        // Increment to get the next available user ID
        return maxUserId + 1;
    }
}
