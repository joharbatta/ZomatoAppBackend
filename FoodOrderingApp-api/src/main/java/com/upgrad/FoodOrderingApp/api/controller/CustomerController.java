package com.upgrad.FoodOrderingApp.api.controller;

import com.upgrad.FoodOrderingApp.api.model.SignupCustomerRequest;
import com.upgrad.FoodOrderingApp.api.model.SignupCustomerResponse;
import com.upgrad.FoodOrderingApp.service.businness.CustomerService;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer/signup",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SignupCustomerResponse> signUpCustomer(@RequestBody SignupCustomerRequest signupCustomerRequest) {

        CustomerEntity customer = new CustomerEntity();
        customer.setUuid(UUID.randomUUID().toString());
        customer.setFirstName(signupCustomerRequest.getFirstName());
        customer.setLastName(signupCustomerRequest.getLastName());
        customer.setEmail(signupCustomerRequest.getEmailAddress());
        customer.setContactNumber(signupCustomerRequest.getContactNumber());
        customer.setPassword(signupCustomerRequest.getPassword());

        CustomerEntity result = customerService.registerCustomer(customer);

        return new ResponseEntity<SignupCustomerResponse>(
                new SignupCustomerResponse().id(result.getUuid()).status("CUSTOMER SUCCESSFULLY REGISTERED"),
                HttpStatus.CREATED);
    }


}
