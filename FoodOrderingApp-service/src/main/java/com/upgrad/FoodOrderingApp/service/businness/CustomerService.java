package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CustomerDAO;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerEntity registerCustomer(CustomerEntity customer) throws SignUpRestrictedException {

        if (isPhoneNumberExist(customer))
            throw new SignUpRestrictedException("SGR-001",
                    "This contact number is already registered! Try other contact number.");
        if (!validateCustomer(customer))
            throw new SignUpRestrictedException("SGR-005", "Except last name all fields should be filled");
        if (!isValidEmailID(customer))
            throw new SignUpRestrictedException("SGR-002", "Invalid email-id format!");
        if (!isValidPhoneNumber(customer))
            throw new SignUpRestrictedException("SGR-003", "Invalid contact number!");
        if (!isValidPassword(customer.getPassword()))
            throw new SignUpRestrictedException("SGR-004", "Weak password!");

        String[] encryptedText = cryptographyProvider.encrypt(customer.getPassword());
        customer.setSalt(encryptedText[0]);
        customer.setPassword(encryptedText[1]);
        return customerDAO.registerCustomer(customer);

    }
    private boolean isPhoneNumberExist(CustomerEntity customer) throws SignUpRestrictedException {
        CustomerEntity customerEntity = customerDAO.getUserByPhoneNumber(customer.getContactNumber());
        if (customerEntity != null) {
            return true;
        } else {
            return false;
        }
    }
    private boolean validateCustomer(CustomerEntity customer) {
        if (customer.getEmail().length() == 0 || customer.getContactNumber().length() == 0
                || customer.getFirstName().length() == 0 || customer.getPassword().length() == 0)
            return false;
        return true;
    }
    private boolean isValidEmailID(CustomerEntity customer) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(customer.getEmail());
        return matcher.find();
    }

    private boolean isValidPhoneNumber(CustomerEntity customer) {
        Pattern pattern = Pattern.compile("^[1-9]+\\d{9}$");
        Matcher matcher = pattern.matcher(customer.getContactNumber());
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        Pattern p1 = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*\\W).*$");
        Matcher matcher = p1.matcher(password);
        return password.length() >= 8 && matcher.matches();
    }
}
