/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.MedicalRecordDAO;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.MedicalRecord;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author HP
 */ 
@Path("/medicalRecord")
public class MedicalRecordResource {
    
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordResource.class); 
    
    // Data Access Object for medical record operations
    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
 
    // Method to get all medical records
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() { 
        try {
            LOGGER.info("Getting all medical records...");
            return medicalRecordDAO.getAllMedicalRecords();
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all medical records: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to get a medical record by ID
    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordById(@PathParam("medicalRecordId") int medicalRecordId) { 
        try {
            LOGGER.info("Getting medical record with id: {}", medicalRecordId);
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
            if (medicalRecord == null) {
                throw new ResourceNotFoundException("Medical Record  with ID " + medicalRecordId + " not found");
            }
            return medicalRecord;
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving medical record with id {}: {}", medicalRecordId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }


    // Method to add a medical record
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addMedicalRecord(MedicalRecord medicalRecord) { 
        try {
            LOGGER.info("Adding a medical record...");
            return medicalRecordDAO.addMedicalRecord(medicalRecord);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding a medical record: {}", e.getMessage());
            throw new InvalidDataException("Invalid data provided for adding a medical record");
        }
    }

    // Method to update a medical record
    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId, MedicalRecord updatedMedicalRecord) {
        try {
            LOGGER.info("Updating medical record with ID: {}", medicalRecordId);
            MedicalRecord existingMedicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);

            if (existingMedicalRecord != null) {
                updatedMedicalRecord.setPatientId(medicalRecordId);
                return medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
            } else {
                throw new ResourceNotFoundException("Medical record with ID " + medicalRecordId + " not found");
            }
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating medical record with id {}: {}", medicalRecordId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        } 
        
    }

    // Method to delete a medical record
    @DELETE
    @Path("/{medicalRecordId}")
    public String deleteMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId) { 
        try {
            LOGGER.info("Deleting medical record with ID: {}", medicalRecordId);
            return medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting medical record with id {}: {}", medicalRecordId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }     
}
