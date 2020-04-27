package com.upgrad.FoodOrderingApp.service.dao;

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
}
