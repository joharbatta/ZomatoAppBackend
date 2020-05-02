package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CategoryDao;
import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import com.upgrad.FoodOrderingApp.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<CategoryEntity> getAllCategories() {

        return categoryDao.getAllCategories();
    }

    public CategoryEntity getCategoryById(String uuid) throws CategoryNotFoundException {
        CategoryEntity categoryEntity = categoryDao.getCategoryById(uuid);
        if(uuid == "") {
            throw new CategoryNotFoundException("CNF-001","Category id field should not be empty");
        } else if(categoryEntity == null) {
            throw new CategoryNotFoundException("CNF-002","No category by this id");
        } else {
            return categoryEntity;
        }
    }

}
