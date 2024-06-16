/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import static com.example.dao.DoctorDAO.doctors;
import static com.example.dao.PatientDAO.patients;
import com.example.dao.PersonDAO;
import com.example.model.Person;
import java.util.List;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HP
 */ 
// Method to get all people
@Path("/people")
public class PersonResource { 

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);
    
    
    private PersonDAO personDAO = new PersonDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople() { 
        try {
            LOGGER.info("Getting all people...");
            return personDAO.getAllPeople(patients, doctors);
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all people: {}", e.getMessage());
            throw new RuntimeException("Internal Server Error", e);
        }

    }


}
