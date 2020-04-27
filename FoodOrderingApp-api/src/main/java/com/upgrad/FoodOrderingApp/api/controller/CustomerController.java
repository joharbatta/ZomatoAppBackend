package com.upgrad.FoodOrderingApp.api.controller;

import com.upgrad.FoodOrderingApp.api.model.LoginResponse;
import com.upgrad.FoodOrderingApp.api.model.LogoutResponse;
import com.upgrad.FoodOrderingApp.api.model.SignupCustomerRequest;
import com.upgrad.FoodOrderingApp.api.model.SignupCustomerResponse;
import com.upgrad.FoodOrderingApp.service.businness.CustomerService;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthTokenEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.AuthenticationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.UUID;
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //signup
    @RequestMapping(value="/customer/signup",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SignupCustomerResponse> signUpCustomer(@RequestBody SignupCustomerRequest signupCustomerRequest) throws SignUpRestrictedException{

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
    //login
    @RequestMapping(method = RequestMethod.POST, path = "/customer/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestHeader("authorization") final String authorization) throws AuthenticationFailedException {

        String[] decodedArray;

        try{
            byte[] decode = Base64.getDecoder().decode(authorization);
            String decodedText = new String(decode);
            decodedArray = decodedText.split(":");
            if (decodedArray.length != 2)
                throw new Exception();
        }
        catch (Exception e) {
            throw new AuthenticationFailedException("ATH-003",
                    "Incorrect format of decoded customer name and password");
        }
        CustomerAuthTokenEntity customerAuthToken = customerService.authenticate(decodedArray[0], decodedArray[1]);
        CustomerEntity customer = customerAuthToken.getUser();
        LoginResponse signinResponse = new LoginResponse().id(customer.getUuid()).firstName(customer.getFirstName())
                .lastName(customer.getLastName()).emailAddress(customer.getEmail())
                .contactNumber(customer.getContactNumber()).message("SIGNED IN SUCCESSFULLY");

        HttpHeaders headers = new HttpHeaders();
        headers.add("access-token", customerAuthToken.getAccessToken());
        return new ResponseEntity<LoginResponse>(signinResponse, headers, HttpStatus.OK);
    }
    //logout
    @RequestMapping(method = RequestMethod.POST, path = "/customer/logout", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<LogoutResponse> loginOut(@RequestHeader("authorization") final String accessToken) throws AuthorizationFailedException {

        final CustomerAuthTokenEntity userAuthToken = customerService.signOutService(accessToken);
        LogoutResponse logoutResponse = new LogoutResponse().
                id(userAuthToken.getUuid()).message("LOGGED OUT SUCCESSFULLY");

        return new ResponseEntity<LogoutResponse>(logoutResponse, HttpStatus.OK);
    }





}
