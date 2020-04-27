package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CustomerDAO;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerEntity registerCustomer(CustomerEntity customer){

        String[] encryptedText = cryptographyProvider.encrypt(customer.getPassword());
        customer.setSalt(encryptedText[0]);
        customer.setPassword(encryptedText[1]);
        return customerDAO.registerCustomer(customer);

    }
}
