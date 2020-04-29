package com.upgrad.FoodOrderingApp.api.controller;

import com.upgrad.FoodOrderingApp.api.model.*;
import com.upgrad.FoodOrderingApp.service.businness.AddressService;
import com.upgrad.FoodOrderingApp.service.businness.CustomerService;
import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import com.upgrad.FoodOrderingApp.service.exception.AddressNotFoundException;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.SaveAddressException;
import com.upgrad.FoodOrderingApp.service.exception.UpdateCustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST,value = "/address", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SaveAddressResponse> postAddress(@RequestHeader("authorization") final String accessToken, @RequestBody SaveAddressRequest saveAddressRequest) throws SaveAddressException, AuthorizationFailedException, UpdateCustomerException {

        if(saveAddressRequest.getStateUuid().isEmpty() || saveAddressRequest.getPincode().isEmpty()
                || saveAddressRequest.getFlatBuildingName().isEmpty() || saveAddressRequest.getLocality().isEmpty()
                || saveAddressRequest.getCity().isEmpty()) {
            throw new SaveAddressException("SAR-001", "No field can be empty");
        }

        AddressEntity newAddress = new AddressEntity();
        newAddress.setCity(saveAddressRequest.getCity());
        newAddress.setFlat_buil_number(saveAddressRequest.getFlatBuildingName());
        newAddress.setLocality(saveAddressRequest.getLocality());
        newAddress.setPincode(saveAddressRequest.getPincode());
//        newAddress.setActive(1);
        newAddress.setUuid(UUID.randomUUID().toString());

        String stateUuid = saveAddressRequest.getStateUuid();

        AddressEntity savedAddress = addressService.saveAddress(newAddress, stateUuid, accessToken);

        CustomerEntity customerEntity = customerService.getCustomerByToken(accessToken);

        addressService.addEntrytoCustomerAddress(customerEntity, savedAddress);

        return new ResponseEntity<SaveAddressResponse>(
                new SaveAddressResponse().id(savedAddress.getUuid()).
                        status("ADDRESS SUCCESSFULLY REGISTERED"),
                HttpStatus.CREATED);

    }

    @GetMapping(value="/address/customer",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<AddressListResponse> retrieveAllAddressForUser(@RequestHeader("authorization") final String accessToken) throws AuthorizationFailedException{

        CustomerEntity customerEntity = customerService.getCustomerByToken(accessToken);
        AddressListResponse response = new AddressListResponse();
        for(AddressEntity addressEntity : customerEntity.getAddress()){
            response.addAddressesItem(new AddressList().
                    id(UUID.fromString(addressEntity.getUuid())).
                    city(addressEntity.getCity()).
                    flatBuildingName(addressEntity.getFlat_buil_number()).
                    locality(addressEntity.getLocality()).
                    city(addressEntity.getCity()).
                    pincode(addressEntity.getPincode()).
                    state(new AddressListState().
                            stateName(addressEntity.getStateEntity().getState_name()).
                            id(UUID.fromString(addressEntity.getStateEntity().getUuid()))));
        }

        return new ResponseEntity<AddressListResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/address/{address_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<DeleteAddressResponse> deleteAddressById(
            @RequestHeader("authorization") final String accessToken,
            @PathVariable final String address_id) throws AddressNotFoundException, AuthorizationFailedException {

        CustomerEntity customerEntity = customerService.getCustomerByToken(accessToken);
        boolean match = false;
        for(AddressEntity address : customerEntity.getAddress()){
            if(address.getUuid().equalsIgnoreCase(address_id))
                match = true;
        }
        AddressEntity addressEntity = addressService.getAddressById(address_id);

        if(address_id.isEmpty())
            throw new AddressNotFoundException("ANF-005", "Address id can not be empty");

        if(addressEntity==null)
            throw new AddressNotFoundException("ANF-003", "No address by this id");

        if(!match)
            throw new AddressNotFoundException("ATHR-004", "You are not authorized to view/update/delete any one else's address");

        AddressEntity deletedEntity = addressService.deleteAddressById(address_id);

        return new ResponseEntity<DeleteAddressResponse>(
                new DeleteAddressResponse().id(UUID.fromString(deletedEntity.getUuid())).
                        status("ADDRESS DELETED SUCCESSFULLY"),HttpStatus.OK);
    }

}
