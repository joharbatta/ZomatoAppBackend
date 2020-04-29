package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StateDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StateEntity> getAllStates()
    {
        return entityManager.createNamedQuery("getAllStates").getResultList();
    }

    public StateEntity getStateById(String uuid) {
        try {
            return entityManager.createNamedQuery("getStateById", StateEntity.class).setParameter("stateuuid", uuid).getSingleResult();
        } catch(NoResultException nre) {
            return null;
        }
    }
}

