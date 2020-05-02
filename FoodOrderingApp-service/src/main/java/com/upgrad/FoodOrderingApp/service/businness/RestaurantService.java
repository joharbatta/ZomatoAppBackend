package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.RestaurantDao;
import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthTokenEntity;
import com.upgrad.FoodOrderingApp.service.entity.RestaurantEntity;
import com.upgrad.FoodOrderingApp.service.exception.AuthorizationFailedException;
import com.upgrad.FoodOrderingApp.service.exception.RestaurantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    public List<RestaurantEntity> getRestaurantsByName(String restName)throws RestaurantNotFoundException {
        if(restName.trim() == "") {
            throw new RestaurantNotFoundException("RNF-003","Restaurant name field should not be empty");
        } else {
            return restaurantDao.getAllRestaurantsByName(restName);
        }
    }

    public RestaurantEntity getRestaurantById(String restUuid) throws RestaurantNotFoundException {
        if (restUuid.trim() == "") {
            throw new RestaurantNotFoundException("RNF-002","Restaurant id field should not be empty");
        } else {
            RestaurantEntity restEntity = restaurantDao.getRestaurantById(restUuid);
            if(restEntity == null) {
                throw new RestaurantNotFoundException("RNF-001","No restaurant by this id");
            } else {
                return restEntity;
            }
        }
    }



}
