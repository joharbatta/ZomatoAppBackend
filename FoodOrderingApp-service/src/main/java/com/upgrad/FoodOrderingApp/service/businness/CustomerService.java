package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CustomerDAO;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthTokenEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.AuthenticationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
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

    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerAuthTokenEntity authenticate(final String phone, final String password) throws AuthenticationFailedException {

        boolean isDataAlreadyExists = false;
        CustomerAuthTokenEntity customerAuthTokenEntity = null;

        //checking is no exist
        CustomerEntity customerEntity = customerDAO.getUserByPhoneNumber(phone);
        if (customerEntity == null) {
            throw new AuthenticationFailedException("ATH-001", "This contact number has not been registered!");
        }
        //encrypting password
        final String encryptedPassword = cryptographyProvider.encrypt(password, customerEntity.getSalt());

        if (encryptedPassword.equals(customerEntity.getPassword()))
        {
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(encryptedPassword);
            //check if already exists uuid then will update token so it cant generate multiple token
            customerAuthTokenEntity = customerDAO.getCustomerAuthEntityTokenByUUID(customerEntity.getUuid());
            if (customerAuthTokenEntity != null) {
                isDataAlreadyExists = true;
            } else {
                customerAuthTokenEntity = new CustomerAuthTokenEntity();
            }
            customerAuthTokenEntity.setUser(customerEntity);
            final ZonedDateTime now = ZonedDateTime.now();
            final ZonedDateTime expiresAt = now.plusHours(8);
           customerAuthTokenEntity.setAccessToken(jwtTokenProvider.generateToken(customerEntity.getUuid(), now, expiresAt));
           customerAuthTokenEntity.setLoginAt(now);
           customerAuthTokenEntity.setExpiresAt(expiresAt);
            customerAuthTokenEntity.setUuid(customerEntity.getUuid());
            customerAuthTokenEntity.setLogoutAt(null);
            // if already uuid so new token generate for existing previous will merge else another user with new token
            if (isDataAlreadyExists)
                customerDAO.createAuthToken(customerAuthTokenEntity);
            else
                customerDAO.updateLoginInfo(customerAuthTokenEntity);
            return customerAuthTokenEntity;
        }
        else {
            throw new AuthenticationFailedException("ATH-002", "Invalid Credentials");
        }

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
