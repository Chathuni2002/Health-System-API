/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PrescriptionDAO;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Prescription;
import java.util.Collection;
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
@Path("/prescription")
public class PrescriptionResource { 
    
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionResource.class); 
    
    // Data Access Object for prescription operations
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    // Method to get all prescriptions
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Prescription> getAllPrescriptions() { 
        try {
            LOGGER.info("Getting all prescriptions...");
            return prescriptionDAO.getAllPrescriptions();
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all prescriptions: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to get a prescription by ID
    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptionId") int prescriptionId) { 
        try {
            LOGGER.info("Getting prescription with id: {}", prescriptionId);
            Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
            if (prescription == null) {
                throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " not found");
            }
            return prescription;
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving prescription with id {}: {}", prescriptionId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }


    // Method to add a prescription
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPrescription(Prescription prescription) { 
        try {
            LOGGER.info("Adding a prescription...");
            return prescriptionDAO.addPrescription(prescription);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding a prescription: {}", e.getMessage());
            throw new InvalidDataException("Invalid data provided for adding a prescription");
        }
    }

    // Method to update a prescription
    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrescription) {
        try {
            LOGGER.info("Updating prescription with ID: {}", prescriptionId);
            Prescription existingPrescription = prescriptionDAO.getPrescriptionById(prescriptionId);

            if (existingPrescription != null) {
                updatedPrescription.setPrescriptionId(prescriptionId);
                return prescriptionDAO.updatePrescription(prescriptionId, updatedPrescription);
            } else {
                throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " not found");
            }
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating prescription with id {}: {}", prescriptionId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to delete a prescription
    @DELETE
    @Path("/{prescriptionId}")
    public String deletePrescription(@PathParam("prescriptionId") int prescriptionId) { 
        try {
            LOGGER.info("Deleting prescription with ID: {}", prescriptionId);
            return prescriptionDAO.deletePrescription(prescriptionId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting prescription with id {}: {}", prescriptionId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }    
}
