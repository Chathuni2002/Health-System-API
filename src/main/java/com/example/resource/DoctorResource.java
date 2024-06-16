/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.DoctorDAO;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Doctor;
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
@Path("/doctor")
public class DoctorResource { 
    
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorResource.class);
    
    // Data Access Object for doctor operations
    private DoctorDAO doctorDAO = new DoctorDAO();
    
    
    // Method to get all doctors
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Doctor> getAllDoctors() { 
        try {
            LOGGER.info("Getting all doctors...");
            return doctorDAO.getAllDoctors();
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all doctors: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to get a doctor by ID
    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") int doctorId) { 
        try {
            LOGGER.info("Getting doctor with id: {}", doctorId);
            Doctor doctor = doctorDAO.getDoctorById(doctorId);
            if (doctor == null) {
                throw new ResourceNotFoundException("Doctor with ID " + doctorId + " not found");
            }
            return doctor;
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving doctor with id {}: {}", doctorId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }


    // Method to add a doctor
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addDoctor(Doctor doctor) { 
        try {
            LOGGER.info("Adding a doctor...");
            return doctorDAO.addDoctor(doctor);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding a doctor: {}", e.getMessage());
            throw new InvalidDataException("Invalid data provided for adding a doctor");
        }
    }

    // Method to update a doctor
    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) { 
        try {
            LOGGER.info("Updating doctor with ID: {}", doctorId);
            Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);

            if (existingDoctor != null) {
                updatedDoctor.setDrId(doctorId);
                return doctorDAO.updateDoctor(doctorId, updatedDoctor);
            } else {
                throw new ResourceNotFoundException("Doctor with ID " + doctorId + " not found");
            }
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating doctor with id {}: {}", doctorId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to delete a doctor
    @DELETE
    @Path("/{doctorId}")
    public String deleteDoctor(@PathParam("doctorId") int doctorId) { 
        try {
            LOGGER.info("Deleting doctor with ID: {}", doctorId);
            return doctorDAO.deleteDoctor(doctorId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting doctor with id {}: {}", doctorId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }    
}
