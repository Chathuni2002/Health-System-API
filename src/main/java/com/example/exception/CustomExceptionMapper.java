/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.exception;

/**
 *
 * @author HP
 */ 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider; 

@Provider
public class CustomExceptionMapper implements ExceptionMapper<RuntimeException> { 
    // Logger for logging exception details
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionMapper.class);
    
    // Method to handle exceptions and map them to appropriate HTTP responses
    @Override 
    public Response toResponse(RuntimeException exception) {
        LOGGER.error("RuntimeException caught: {}", exception.getMessage(), exception);
        // Check the type of exception and map it to the corresponding HTTP response
        if (exception instanceof ResourceNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity(exception.getMessage())
                           .type(MediaType.TEXT_PLAIN)
                           .build();
        } else if (exception instanceof InvalidDataException) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(exception.getMessage())
                           .type(MediaType.TEXT_PLAIN)
                           .build();
        } else {
            // For any other type of exception, return an internal server error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal Server Error")
                           .type(MediaType.TEXT_PLAIN)
                           .build();
        }
    }    
        
} 

