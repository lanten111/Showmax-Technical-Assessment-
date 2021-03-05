package co.za.assessment.rest;
/*
created by mumakhado on 2021/03/04
*/
import co.za.assessment.models.Customer;
import co.za.assessment.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @Autowired
    CustomerRepo customerRepo;
    //would create a service class that deals with all logic and db queries

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer){
        //save also implements update, so to create customer, add new id
        return customerRepo.save(customer);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer updateCustomer(@RequestBody Customer customer){
        //save also implements update if the id exist in the table, record will be updated, dont change the id for update
        return customerRepo.save(customer);
    }

    @DeleteMapping(path = "/{customerNumber}", produces = "application/json")
    public Long deleteCustomer(@PathVariable("customerNumber") String customerNumber){
        //will return number of records deleted
        return customerRepo.deleteCustomerByCustomerNumber(customerNumber);
    }

    @GetMapping(path = "/{customerNumber}", produces = "application/json")
    public Customer getCustomer(@PathVariable("customerNumber") String customerNumber){
        Customer customer = customerRepo.getCustomerByCustomerNumber(customerNumber);
        if (!customer.isStatusActive()){
            //if account is inactive return 401
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            return customer;
        }
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Customer> getAllCustomer(){
        //return a list of all customer in the database, including incative accound
        return  customerRepo.findAll();
    }
}
