/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.BillingDAO;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Billing;
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
@Path("/billing")
public class BillingResource {  
    
    // Logger for logging information and errors
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingResource.class); 
    
    // Data Access Object for billing operations
    private BillingDAO billingDAO = new BillingDAO();

    // Method to get all billings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Billing> getAllBillings() { 
        try {
            LOGGER.info("Getting all billings...");
            return billingDAO.getAllBillings();
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all billings: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to get a billing by ID
    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingById(@PathParam("billingId") int billingId) { 
        try {
            LOGGER.info("Getting billing with id: {}", billingId);
            Billing billing = billingDAO.getBillingById(billingId);
            if (billing == null) {
                throw new ResourceNotFoundException("Billing with ID " + billingId + " not found");
            }
            return billing;
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving billing with id {}: {}", billingId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }


    // Method to add a billing
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addBilling(Billing billing) { 
        try {
            LOGGER.info("Adding a billing...");
            return billingDAO.addBilling(billing);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding a billing: {}", e.getMessage());
            throw new InvalidDataException("Invalid data provided for adding a billing");
        }
    }

    // Method to update a billing
    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateBilling(@PathParam("billingId") int billingId, Billing updatedBilling) { 
        try {
            LOGGER.info("Updating billing with ID: {}", billingId);
            Billing existingBilling = billingDAO.getBillingById(billingId);

            if (existingBilling != null) {
                updatedBilling.setBillingId(billingId);
                return billingDAO.updateBilling(billingId, updatedBilling);
            } else {
                throw new ResourceNotFoundException("Billing with ID " + billingId + " not found");
            }
        } catch (ResourceNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating billing with id {}: {}", billingId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    // Method to delete a billing
    @DELETE
    @Path("/{billingId}")
    public String deleteBilling(@PathParam("billingId") int billingId) { 
        try {
            LOGGER.info("Deleting billing with ID: {}", billingId);
            return billingDAO.deleteBilling(billingId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting billing with id {}: {}", billingId, e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }
    }
}
