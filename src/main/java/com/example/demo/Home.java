package com.example.demo;

import java.util.ArrayList;

public class Home {
    private ArrayList<Customer> customers;

    Home(){};

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer) {
        this.customers.add(customer);
    }
}
