package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.AddressDAO;
import com.upgrad.FoodOrderingApp.service.dao.CustomerDAO;
import com.upgrad.FoodOrderingApp.service.dao.StateDAO;
import com.upgrad.FoodOrderingApp.service.entity.*;
import com.upgrad.FoodOrderingApp.service.exception.AddressNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.SaveAddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.NoResultException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class AddressService {

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    StateDAO stateDAO;


    @Transactional(propagation = Propagation.REQUIRED)
    public AddressEntity saveAddress(AddressEntity address, String uuId, String authorization) throws SaveAddressException, AuthorizationFailedException {
        CustomerAuthTokenEntity customerAuthTokenEntity = customerDAO.getUserAuthToken(authorization);
        if(customerAuthTokenEntity == null) {
            throw new AuthorizationFailedException("ATHR-001","Customer is not Logged in.");
        } else if(customerAuthTokenEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002","Customer is logged out. Log in again to access this endpoint.");
        } else if(customerAuthTokenEntity.getExpiresAt().isBefore(ZonedDateTime.now())) {
            throw new AuthorizationFailedException("ATHR-003","Your session is expired. Log in again to access this endpoint.");
        } else if(!isPinCodeValid(address.getPincode())) {
            throw new SaveAddressException("SAR-002","Invalid pincode");
        }

        StateEntity stateEntity = getStateById(uuId);

        if(stateEntity==null)
            throw new SaveAddressException("ANF-002","No state by this id");

        address.setStateEntity(stateEntity);
        return addressDAO.saveAddress(address);

    }


    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerAddressEntity addEntrytoCustomerAddress(CustomerEntity customerEntity, AddressEntity addressEntity) {
        CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();
        customerAddressEntity.setAddress(addressEntity);
        customerAddressEntity.setCustomer(customerEntity);
        return addressDAO.addEntrytoCustomerAddress(customerAddressEntity);
    }

    private boolean isPinCodeValid(String pinCode){
        Pattern digitPattern = Pattern.compile("\\d{6}");
        return digitPattern.matcher(pinCode).matches();
    }

    private StateEntity getStateById(String uuId){
        return stateDAO.getStateById(uuId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public AddressEntity deleteAddressById(String addressId) throws AddressNotFoundException {
        if(addressId.isEmpty())
            throw new AddressNotFoundException("ANF-005","Address id can not be empty");
        AddressEntity addressEntity = getAddressById(addressId);
        if(addressEntity==null)
            throw new AddressNotFoundException("ANF-003", "No address by this id");
        else {
           return addressDAO.deleteAddressById(addressEntity);
        }

    }

    public AddressEntity getAddressById(String addressId){
        try {
            return addressDAO.getAddressById(addressId);
        } catch (NoResultException nre) {
            return null;
        }
    }

}
