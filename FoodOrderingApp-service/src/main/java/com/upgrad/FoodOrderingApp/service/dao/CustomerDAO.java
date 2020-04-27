package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthTokenEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
@Repository
public class CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public CustomerEntity registerCustomer(CustomerEntity customer)
    {
        entityManager.persist(customer);
        return customer;
    }
    public CustomerEntity getUserByPhoneNumber(final String phoneNumber) {
        try {
            return entityManager.createNamedQuery("customerByPhoneNumber", CustomerEntity.class)
                    .setParameter("contact_number", phoneNumber).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    //create new token for previous user
    public CustomerAuthTokenEntity createAuthToken(final CustomerAuthTokenEntity customerAuthTokenEntity) {
        entityManager.persist(customerAuthTokenEntity);
        return customerAuthTokenEntity;
    }
    // new user update
    public CustomerAuthTokenEntity updateLoginInfo(final CustomerAuthTokenEntity userAuthTokenEntity) {
        try {
            return entityManager.merge(userAuthTokenEntity);
        } catch (NoResultException nre) {
            return null;
        }
    }

    public CustomerAuthTokenEntity getCustomerAuthEntityTokenByUUID(final String UUID) {
        try {
            return entityManager.createNamedQuery("userAuthTokenByUUID", CustomerAuthTokenEntity.class)
                    .setParameter("uuid", UUID).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
