package co.za.assessment.repository;
/*
created by mumakhado on 2021/03/04
*/

import co.za.assessment.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {

    Long deleteCustomerByCustomerNumber(String customerNumber);

    Customer getCustomerByCustomerNumber(String customerNumber);
}
