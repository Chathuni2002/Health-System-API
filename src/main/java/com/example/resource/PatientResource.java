/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PatientDAO;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Patient;
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
@Path("/patient")
public class PatientResource { 
    
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientResource.class);
    
    // Data Access Object for patient operations
    private PatientDAO patientDAO = new PatientDAO();
    
    
    // Method to get all patients
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Patient> getAllPatients() { 
        try {
            LOGGER.info("Getting all patients...");
            return patientDAO.getAllPatients();
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all patients: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to get a patient by ID
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("patientId") int patientId) { 
        try {
            LOGGER.info("Getting patient with id: {}", patientId);
            Patient patient = patientDAO.getPatientById(patientId);
            if (patient == null) {
                throw new ResourceNotFoundException("Patient with ID " + patientId + " not found");
            }
            return patient;
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving patient with id {}: {}", patientId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }


    // Method to add a patient
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPatient(Patient patient) { 
        try {
            LOGGER.info("Adding a patient...");
            return patientDAO.addPatient(patient);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding a patient: {}", e.getMessage());
            throw new InvalidDataException("Invalid data provided for adding a patient");
        }
    }

    // Method to update a patient
    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) { 
        try {
            LOGGER.info("Updating patient with ID: {}", patientId);
            Patient existingPatient = patientDAO.getPatientById(patientId);

            if (existingPatient != null) {
                updatedPatient.setPatientId(patientId);
                return patientDAO.updatePatient(patientId, updatedPatient);
            } else {
                throw new ResourceNotFoundException("Patient with ID " + patientId + " not found");
            }
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating patient with id {}: {}", patientId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to delete a patient
    @DELETE
    @Path("/{patientId}")
    public String deletePatient(@PathParam("patientId") int patientId) { 
        try {
            LOGGER.info("Deleting patient with ID: {}", patientId);
            return patientDAO.deletePatient(patientId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting patient with id {}: {}", patientId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }    
}
