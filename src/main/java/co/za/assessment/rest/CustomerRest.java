package co.za.assessment.rest;
/*
created by mumakhado on 2021/03/04
*/
import co.za.assessment.models.Customer;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer createCustomer(@RequestParam("customer") Customer customer){
        return null;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Customer updateCustomer(@RequestParam("customer") Customer customer){
        return null;
    }

    @DeleteMapping(path = "/{customerNumber}", produces = "application/json")
    public Customer deleteCustomer(){
        return null;
    }

    @GetMapping(path = "/{customerNumber}", produces = "application/json")
    public Customer getCustomer(){
        return null;
    }

    @GetMapping(path = "/", produces = "application/json")
    public Customer getAllCustomer(){
        return null;
    }
}
