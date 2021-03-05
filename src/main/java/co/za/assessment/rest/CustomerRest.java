package co.za.assessment.rest;
/*
created by mumakhado on 2021/03/04
*/
import co.za.assessment.models.Customer;
import co.za.assessment.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @Autowired
    CustomerRepo customerRepo;

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer){
        //save also implements update, so to create customer, add new id
        return customerRepo.save(customer);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer updateCustomer(@RequestBody Customer customer){
        //save also implements update if the id exist in the table, so to update customer, dont change the id
        return customerRepo.save(customer);
    }

    @DeleteMapping(path = "/{customerNumber}", produces = "application/json")
    public Long deleteCustomer(@PathVariable("customerNumber") String customerNumber){
        return customerRepo.deleteCustomerByCustomerNumber(customerNumber);
    }

    @GetMapping(path = "/{customerNumber}", produces = "application/json")
    public List<Customer> getCustomer(@PathVariable("customerNumber") String customerNumber){
        //return a list, for a possible duplicate of customer
        return  customerRepo.getCustomerByCustomerNumber(customerNumber);
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Customer> getAllCustomer(){
        return  customerRepo.findAll();
    }
}
