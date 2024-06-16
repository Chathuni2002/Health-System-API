/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author HP
 */
public class Doctor extends Person{
    private int drId; 
    private String specialization; 
    private String workEmail; 
    
    public Doctor(){
        
    }
    
    public Doctor(String name, String contactNo, String address, int age, int drId, String specialization, String workEmail){
        super(name, contactNo, address, age); 
        this.drId = drId; 
        this.specialization = specialization; 
        this.workEmail = workEmail;
    } 

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }
    
    
}
