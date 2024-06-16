/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.AppointmentDAO;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Appointment;
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
@Path("/appointment")
public class AppointmentResource {
    
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentResource.class); 
    
    // Data Access Object for appointment operations
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    // Method to get all appointments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAllAppointments() { 
        try {
            LOGGER.info("Getting all appointments...");
            return appointmentDAO.getAllAppointments();
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all appointments: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to get a appointment by ID
    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId) { 
        try {
            LOGGER.info("Getting appointment with id: {}", appointmentId);
            Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
            if (appointment == null) {
                throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found");
            }
            return appointment;
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving appointment with id {}: {}", appointmentId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }


    // Method to add a appointment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addAppointment(Appointment appointment) { 
        try {
            LOGGER.info("Adding a appointment...");
            return appointmentDAO.addAppointment(appointment);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding a appointment: {}", e.getMessage());
            throw new InvalidDataException("Invalid data provided for adding a appointment");
        }
    }

    // Method to update a appointment
    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) { 
        try {
            LOGGER.info("Updating appointment with ID: {}", appointmentId);
            Appointment existingAppointment = appointmentDAO.getAppointmentById(appointmentId);

            if (existingAppointment != null) {
                updatedAppointment.setAppointmentNo(appointmentId);
                return appointmentDAO.updateAppointment(appointmentId, updatedAppointment);
            } else {
                throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found");
            }
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating appointment with id {}: {}", appointmentId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to delete a appointment
    @DELETE
    @Path("/{appointmentId}")
    public String deleteAppointment(@PathParam("appointmentId") int appointmentId) { 
        try {
            LOGGER.info("Deleting appointment with ID: {}", appointmentId);
            return appointmentDAO.deleteAppointment(appointmentId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting appointment with id {}: {}", appointmentId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }    
}
