/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;


/**
 *
 * @author HP
 */
public class Billing {
    private int billingId;
    private int patientId; 
    private double payment; 
    private double balance; 
    private String date;
    private String invoice; 
    
    public Billing(){
        
    }
    
    public Billing(int billingId, int patientId, double payment, double balance, String date, String invoice){
        this.billingId = billingId;
        this.patientId = patientId;
        this.payment = payment; 
        this.balance = balance;
        this.date = date;
        this.invoice = invoice; 
    } 

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
    
    
}
