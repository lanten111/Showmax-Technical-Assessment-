package co.za.assessment;

import co.za.assessment.models.Customer;
import co.za.assessment.repository.CustomerRepo;
import co.za.assessment.rest.CustomerRest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest
@AutoConfigureMockMvc
@ContextConfiguration
@RunWith(SpringRunner.class)
class AssessmentApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRest customerRest;

    @MockBean
    private CustomerRepo customerRepo;

    @Test
    public void CreateCustomer() throws Exception {
        Customer customer = new Customer();
        //create new customer
        customer.setId(6);
        customer.setCustomerNumber("66");
        customer.setName("bruce");
        customer.setStatusActive(true);
        customer.setSurname("wayne");
        CreateCustomer(customer);


    }

    @Test
    public void updateCustomer() throws Exception {
        Customer customer = new Customer();
        //update customer
        customer.setId(6); //use exisiting id to update
        customer.setSurname("Stack");  //updated surname
        updateCustomer(customer);

    }

    @Test
    public void getCustomer() throws Exception {

        getCustomer("66"); //get customer 66
    }

    @Test
    public void TestGetAllCustomer() throws Exception {

        getAllCustomer(); //get all customer in db
    }

    @Test
    public void deleteCustomer() throws Exception {

        deleteCustomer("66"); //delete customer 66

    }

    private void CreateCustomer(Customer customer) throws Exception {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(customer);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/customer/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    private void updateCustomer(Customer customer) throws Exception {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(customer);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/customer/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    private void getCustomer(String customerNumber) throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/"+customerNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    private void getAllCustomer() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    private void deleteCustomer(String customerNumber) throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/customer/"+ customerNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }


}
