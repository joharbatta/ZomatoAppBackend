package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAddressEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Repository
public class AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressEntity saveAddress(AddressEntity address) {
        entityManager.persist(address);
        return address;
    }
    public CustomerAddressEntity addEntrytoCustomerAddress(CustomerAddressEntity customerAddressEntity) {
        entityManager.persist(customerAddressEntity);
        return customerAddressEntity;
    }

    public AddressEntity getAddressById(String addressId){
        try {
            return entityManager.createNamedQuery("getAddressById", AddressEntity.class).setParameter("addressuuid", addressId).getSingleResult();
        } catch(NoResultException nre) {
            return null;
        }
    }
    public void deleteAddressById(AddressEntity address) {
        entityManager.remove(address);
    }
}