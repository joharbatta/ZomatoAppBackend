//package com.upgrad.FoodOrderingApp.api.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.upgrad.FoodOrderingApp.api.model.RestaurantList;
//import com.upgrad.FoodOrderingApp.api.model.RestaurantListResponse;
//import com.upgrad.FoodOrderingApp.service.entity.*;
//import com.upgrad.FoodOrderingApp.service.exception.CategoryNotFoundException;
//import com.upgrad.FoodOrderingApp.service.exception.RestaurantNotFoundException;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//import java.util.UUID;
//
//import static com.upgrad.FoodOrderingApp.service.common.ItemType.NON_VEG;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//// This class contains all the test cases regarding the restaurant controller
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class RestaurantControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private RestaurantService mockRestaurantService;
//
//    @MockBean
//    private ItemService mockItemService;
//
//    @MockBean
//    private CategoryService mockCategoryService;
//
//    @MockBean
//    private CustomerService mockCustomerService;
//
//    // ------------------------------------------ GET /restaurant/{restaurant_id} ------------------------------------------
//
//    //This test case passes when you get restaurant details based on restaurant id.
//    @Test
//    public void shouldGetRestaurantDetailsForCorrectRestaurantId() throws Exception {
//        final RestaurantEntity restaurantEntity = getRestaurantEntity();
//        when(mockRestaurantService.restaurantByUUID("someRestaurantId"))
//                .thenReturn(restaurantEntity);
//
//        final CategoryEntity categoryEntity = getCategoryEntity();
//        when(mockCategoryService.getCategoriesByRestaurant("someRestaurantId"))
//                .thenReturn(Collections.singletonList(categoryEntity));
//
//        final ItemEntity itemEntity = getItemEntity();
//        when(mockItemService.getItemsByCategoryAndRestaurant("someRestaurantId", categoryEntity.getUuid()))
//                .thenReturn(Collections.singletonList(itemEntity));
//
//        mockMvc
//                .perform(get("/restaurant/someRestaurantId").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("id").value(restaurantEntity.getUuid()))
//                .andExpect(jsonPath("restaurant_name").value("Famous Restaurant"))
//                .andExpect(jsonPath("customer_rating").value(3.4))
//                .andExpect(jsonPath("number_customers_rated").value(200));
//        verify(mockRestaurantService, times(1)).restaurantByUUID("someRestaurantId");
//        verify(mockCategoryService, times(1)).getCategoriesByRestaurant("someRestaurantId");
//        verify(mockItemService, times(1))
//                .getItemsByCategoryAndRestaurant("someRestaurantId", categoryEntity.getUuid());
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch any restaurant but your restaurant id
//    // field is empty.
//    @Test
//    public void shouldNotGetRestaurantidIfRestaurantIdIsEmpty() throws Exception {
//        when(mockRestaurantService.restaurantByUUID(anyString()))
//                .thenThrow(new RestaurantNotFoundException("RNF-002", "Restaurant id field should not be empty"));
//
//        mockMvc
//                .perform(get("/restaurant/emptyString").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("RNF-002"));
//        verify(mockRestaurantService, times(1)).restaurantByUUID(anyString());
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch restaurant details while there are
//    // no restaurants with that restaurant id.
//    @Test
//    public void shouldNotGetRestaurantDetailsIfRestaurantNotFoundForGivenRestaurantId() throws Exception {
//        when(mockRestaurantService.restaurantByUUID("someRestaurantId"))
//                .thenThrow(new RestaurantNotFoundException("RNF-001", "No restaurant by this id"));
//
//        mockMvc
//                .perform(get("/restaurant/someRestaurantId").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("RNF-001"));
//        verify(mockRestaurantService, times(1)).restaurantByUUID("someRestaurantId");
//        verify(mockCategoryService, times(0)).getCategoriesByRestaurant(anyString());
//        verify(mockItemService, times(0)).getItemsByCategoryAndRestaurant(anyString(), anyString());
//    }
//
//    // ------------------------------------------ GET /restaurant/name/{restaurant_name} ------------------------------------------
//
//    //This test case passes when you are able to fetch restaurants by the name you provided.
//    @Test
//    public void shouldGetRestaurantDetailsByGivenName() throws Exception {
//        final RestaurantEntity restaurantEntity = getRestaurantEntity();
//        when(mockRestaurantService.restaurantsByName("someRestaurantName"))
//                .thenReturn(Collections.singletonList(restaurantEntity));
//
//        final CategoryEntity categoryEntity = getCategoryEntity();
//        when(mockCategoryService.getCategoriesByRestaurant(restaurantEntity.getUuid()))
//                .thenReturn(Collections.singletonList(categoryEntity));
//
//        final String responseString = mockMvc
//                .perform(get("/restaurant/name/someRestaurantName").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        final RestaurantListResponse restaurantListResponse = new ObjectMapper().readValue(responseString, RestaurantListResponse.class);
//        assertEquals(restaurantListResponse.getRestaurants().size(), 1);
//
//        final RestaurantList restaurantList = restaurantListResponse.getRestaurants().get(0);
//        assertEquals(restaurantList.getId().toString(), restaurantEntity.getUuid());
//        assertEquals(restaurantList.getAddress().getId().toString(), restaurantEntity.getAddress().getUuid());
//        assertEquals(restaurantList.getAddress().getState().getId().toString(), restaurantEntity.getAddress().getState().getUuid());
//
//        verify(mockRestaurantService, times(1)).restaurantsByName("someRestaurantName");
//        verify(mockCategoryService, times(1)).getCategoriesByRestaurant(restaurantEntity.getUuid());
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch any restaurants but your restaurant name
//    // field is empty.
//    @Test
//    public void shouldNotGetRestaurantByNameIfNameIsEmpty() throws Exception {
//        when(mockRestaurantService.restaurantsByName(anyString()))
//                .thenThrow(new RestaurantNotFoundException("RNF-003", "Restaurant name field should not be empty"));
//
//        mockMvc
//                .perform(get("/restaurant/name/emptyString").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("RNF-003"));
//        verify(mockRestaurantService, times(1)).restaurantsByName(anyString());
//    }
//
//
//    // ------------------------------------------ GET /restaurant/category/{category_id} ------------------------------------------
//
//    //This test case passes when you are able to retrieve restaurant belonging to any particular categories.
//    @Test
//    public void shouldGetRestaurantDetailsByGivenCategoryId() throws Exception {
//        final RestaurantEntity restaurantEntity = getRestaurantEntity();
//        when(mockRestaurantService.restaurantByCategory("someCategoryId"))
//                .thenReturn(Collections.singletonList(restaurantEntity));
//
//        final CategoryEntity categoryEntity = getCategoryEntity();
//        when(mockCategoryService.getCategoriesByRestaurant(restaurantEntity.getUuid()))
//                .thenReturn(Collections.singletonList(categoryEntity));
//
//        final String responseString = mockMvc
//                .perform(get("/restaurant/category/someCategoryId").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        final RestaurantListResponse restaurantListResponse = new ObjectMapper().readValue(responseString, RestaurantListResponse.class);
//        assertEquals(restaurantListResponse.getRestaurants().size(), 1);
//
//        final RestaurantList restaurantList = restaurantListResponse.getRestaurants().get(0);
//        assertEquals(restaurantList.getId().toString(), restaurantEntity.getUuid());
//        assertEquals(restaurantList.getAddress().getId().toString(), restaurantEntity.getAddress().getUuid());
//        assertEquals(restaurantList.getAddress().getState().getId().toString(), restaurantEntity.getAddress().getState().getUuid());
//
//        verify(mockRestaurantService, times(1)).restaurantByCategory("someCategoryId");
//        verify(mockCategoryService, times(1)).getCategoriesByRestaurant(restaurantEntity.getUuid());
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch any restaurants but your category id
//    // field is empty.
//    @Test
//    public void shouldNotGetRestaurantByCategoryidIfCategoryIdIsEmpty() throws Exception {
//        when(mockRestaurantService.restaurantByCategory(anyString()))
//                .thenThrow(new CategoryNotFoundException("CNF-001", "Category id field should not be empty"));
//
//        mockMvc
//                .perform(get("/restaurant/category/emptyString").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("CNF-001"));
//        verify(mockRestaurantService, times(1)).restaurantByCategory(anyString());
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch any restaurant by its category id, while there
//    // is not category by that id in the database
//    @Test
//    public void shouldNotGetRestaurantsByCategoryIdIfCategoryDoesNotExistAgainstGivenId() throws Exception {
//        when(mockRestaurantService.restaurantByCategory("someCategoryId"))
//                .thenThrow(new CategoryNotFoundException("CNF-002", "No category by this id"));
//
//        mockMvc
//                .perform(get("/restaurant/category/someCategoryId").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("CNF-002"));
//        verify(mockRestaurantService, times(1)).restaurantByCategory("someCategoryId");
//    }
//
//
//    // ------------------------------------------ GET /restaurant ------------------------------------------
//
//    //This test case passes when you able to fetch the list of all restaurants.
//    @Test
//    public void shouldGetAllRestaurantDetails() throws Exception {
//        final RestaurantEntity restaurantEntity = getRestaurantEntity();
//        when(mockRestaurantService.restaurantsByRating())
//                .thenReturn(Collections.singletonList(restaurantEntity));
//
//        final CategoryEntity categoryEntity = getCategoryEntity();
//        when(mockCategoryService.getCategoriesByRestaurant(restaurantEntity.getUuid()))
//                .thenReturn(Collections.singletonList(categoryEntity));
//
//        final String responseString = mockMvc
//                .perform(get("/restaurant").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        final RestaurantListResponse restaurantListResponse = new ObjectMapper().readValue(responseString, RestaurantListResponse.class);
//        assertEquals(restaurantListResponse.getRestaurants().size(), 1);
//
//        final RestaurantList restaurantList = restaurantListResponse.getRestaurants().get(0);
//        assertEquals(restaurantList.getId().toString(), restaurantEntity.getUuid());
//        assertEquals(restaurantList.getAddress().getId().toString(), restaurantEntity.getAddress().getUuid());
//        assertEquals(restaurantList.getAddress().getState().getId().toString(), restaurantEntity.getAddress().getState().getUuid());
//
//        verify(mockRestaurantService, times(1)).restaurantsByRating();
//        verify(mockCategoryService, times(1)).getCategoriesByRestaurant(restaurantEntity.getUuid());
//    }
//
//    // ------------------------------------------ POJO builders ------------------------------------------
//
//    private ItemEntity getItemEntity() {
//        final ItemEntity itemEntity = new ItemEntity();
//        final String itemId = UUID.randomUUID().toString();
//        itemEntity.setUuid(itemId);
//        itemEntity.setItemName("someItem");
//        itemEntity.setType(NON_VEG);
//        itemEntity.setPrice(200);
//        return itemEntity;
//    }
//
//    private CategoryEntity getCategoryEntity() {
//        final CategoryEntity categoryEntity = new CategoryEntity();
//        final String categoryId = UUID.randomUUID().toString();
//        categoryEntity.setUuid(categoryId);
//        categoryEntity.setCategoryName("someCategory");
//        return categoryEntity;
//    }
//
//    private RestaurantEntity getRestaurantEntity() {
//        final String stateId = UUID.randomUUID().toString();
//        final StateEntity stateEntity = new StateEntity(stateId, "someState");
//        final String addressId = UUID.randomUUID().toString();
//        final AddressEntity addressEntity = new AddressEntity(addressId, "a/b/c", "someLocality", "someCity", "100000", stateEntity);
//
//        final RestaurantEntity restaurantEntity = new RestaurantEntity();
//        final String restaurantId = UUID.randomUUID().toString();
//        restaurantEntity.setUuid(restaurantId);
//        restaurantEntity.setAddress(addressEntity);
//        restaurantEntity.setAvgPrice(123);
//        restaurantEntity.setCustomerRating(3.4);
//        restaurantEntity.setNumberCustomersRated(200);
//        restaurantEntity.setPhotoUrl("someurl");
//        restaurantEntity.setRestaurantName("Famous Restaurant");
//        return restaurantEntity;
//    }
//}