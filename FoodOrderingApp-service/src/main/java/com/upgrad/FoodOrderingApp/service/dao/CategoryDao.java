package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CategoryEntity> getAllCategories() {
        return  entityManager.createNamedQuery("allCategories", CategoryEntity.class).getResultList();
    }

    public CategoryEntity getCategoryById(String uuid) {
        try {
            return entityManager.createNamedQuery("categoryById", CategoryEntity.class).setParameter("catuuid", uuid).getSingleResult();
        } catch(NoResultException nre) {
            return null;
        }
    }
}
