package com.example.lab03;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class CustomerController {
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerController(){
        customers.add(new Customer("1010", "John", "Male", 25));
        customers.add(new Customer("1018", "Peter", "Male", 24));
        customers.add(new Customer("1019", "Sara", "Female", 23));
        customers.add(new Customer("1010", "Rose", "Female", 23));
        customers.add(new Customer("1001", "Emma", "Female", 30));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList getCustomer(){
        return customers;
    }
    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String id){
        for (Customer customer:customers) {
            if (customer.getID().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerbyname/{name}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("name") String n){
        for (Customer customer:customers) {
            if (customer.getName().equals(n)) {
                return customer;
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        return customers.removeIf(cus -> (cus.getID().equals(ID))) ? true : false;
    }
    @RequestMapping(value = "/customerDelByname/{name}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("name") String n){
        return customers.removeIf(cus -> (cus.getName().equals(n))) ? true : false;
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        return customers.add(new Customer(ID, n, s, a)) ? true : false;
    }
    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") int a){
        return customers.add(new Customer(ID, n, s, a)) ? true : false;
    }
}
