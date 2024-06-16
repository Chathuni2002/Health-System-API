/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class PersonDAO {
    public static Map<Integer, Person> people = new HashMap<>(); 
    
    // Method to get all people
    public List<Person> getAllPeople(Map<Integer, Patient> patients, Map<Integer, Doctor> doctors) {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(patients.values());
        allPeople.addAll(doctors.values());
        return allPeople;
    }

}
