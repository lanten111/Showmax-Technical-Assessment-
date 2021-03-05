package co.za.assessment.rest;
/*
created by mumakhado on 2021/03/04
*/
import co.za.assessment.models.Customer;
import co.za.assessment.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
@RequestMapping("/customer")
public class CustomerRest {

    CustomerService customerService = new CustomerService();

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestBody Customer customer){
      return customerService.createCustomer(customer);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer updateCustomer(@RequestParam("customer") Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping(path = "/{customerNumber}", produces = "application/json")
    public void deleteCustomer(@PathVariable("customerNumber") String customerNumber){
         customerService.deleteCustomer(customerNumber);
    }

    @GetMapping(path = "/{customerNumber}", produces = "application/json")
    public Customer getCustomer(@PathVariable("customerNumber") int customerNumber){
        return customerService.getCustomer(customerNumber);
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Customer> getAllCustomer(){
       return customerService.getAllCustomer();
    }
}
