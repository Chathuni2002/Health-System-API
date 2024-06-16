/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author HP
 */
public class Person {
    private String name;  
    private String contactNo; 
    private String address; 
    private int age; 
    
    public Person(){
        
    }
    
    public Person(String name, String contactNo, String address, int age){
        this.name = name; 
        this.contactNo = contactNo; 
        this.address = address; 
        this.age = age;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
