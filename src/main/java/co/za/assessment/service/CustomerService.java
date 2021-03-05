package co.za.assessment.service;
/*
created by mumakhado on 2021/03/04
*/

//ADDED service class to perfom all logic and db operations

import co.za.assessment.models.Customer;
import co.za.assessment.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer){
        //customer will be update if same information is provided
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer){
       return customerRepo.save(customer);
    }

    public void deleteCustomer(String customerNumber){
         customerRepo.deleteCustomerByCustomerNumber(customerNumber);
    }

    public Customer getCustomer(int customerNumber){
        return  customerRepo.getCustomerByCustomerNumber(customerNumber);
    }

    public List<Customer> getAllCustomer(){
        return  customerRepo.findAll();
    }


}
