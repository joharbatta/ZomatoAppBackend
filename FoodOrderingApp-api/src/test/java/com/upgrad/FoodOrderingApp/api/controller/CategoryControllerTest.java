//package com.upgrad.FoodOrderingApp.api.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.upgrad.FoodOrderingApp.api.model.CategoriesListResponse;
//import com.upgrad.FoodOrderingApp.api.model.CategoryDetailsResponse;
//import com.upgrad.FoodOrderingApp.api.model.CategoryListResponse;
//import com.upgrad.FoodOrderingApp.service.exception.CategoryNotFoundException;
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
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//// This class contains all the test cases regarding the category controller
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CategoryControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CategoryService mockCategoryService;
//
//    //This test case passes when you have are able to fetch any category by its id.
//    @Test
//    public void shouldGetCategoryById() throws Exception {
//        final ItemEntity itemEntity = new ItemEntity();
//        itemEntity.setItemName("myItem");
//        itemEntity.setPrice(200);
//        itemEntity.setType(NON_VEG);
//        final String itemId = UUID.randomUUID().toString();
//        itemEntity.setUuid(itemId);
//
//        final CategoryEntity categoryEntity = new CategoryEntity();
//        final String categoryEntityId = UUID.randomUUID().toString();
//        categoryEntity.setUuid(categoryEntityId);
//        categoryEntity.setItems(Collections.singletonList(itemEntity));
//
//
//        when(mockCategoryService.getCategoryById("sampleCategoryId")).thenReturn(categoryEntity);
//
//        final String response = mockMvc
//                .perform(get("/category/sampleCategoryId").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        final CategoryDetailsResponse categoryDetailsResponse = new ObjectMapper().readValue(response, CategoryDetailsResponse.class);
//
//        assertEquals(categoryDetailsResponse.getId().toString(), categoryEntityId);
//        assertEquals(categoryDetailsResponse.getItemList().size(), 1);
//        assertEquals(categoryDetailsResponse.getItemList().get(0).getId().toString(), itemId);
//        assertEquals(categoryDetailsResponse.getItemList().get(0).getPrice().intValue(), 200);
//        assertEquals(categoryDetailsResponse.getItemList().get(0).getItemType().toString(), "NON_VEG");
//        verify(mockCategoryService, times(1)).getCategoryById("sampleCategoryId");
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch any category but your category id
//    // field is empty.
//    @Test
//    public void shouldNotGetCategoryByidIfCategoryIdIsEmpty() throws Exception {
//        when(mockCategoryService.getCategoryById(anyString()))
//                .thenThrow(new CategoryNotFoundException("CNF-001", "Category id field should not be empty"));
//
//        mockMvc
//                .perform(get("/category/emptyString").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("CNF-001"));
//        verify(mockCategoryService, times(1)).getCategoryById(anyString());
//    }
//
//    //This test case passes when you have handled the exception of trying to fetch any category by its id, while there
//    // is not category by that id in the database
//    @Test
//    public void shouldNotGetCategoryByIdIfCategoryDoesNotExistAgainstGivenId() throws Exception {
//        when(mockCategoryService.getCategoryById("someCategory"))
//                .thenThrow(new CategoryNotFoundException("CNF-002", "No category by this id"));
//
//        mockMvc
//                .perform(get("/category/someCategory").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("code").value("CNF-002"));
//        verify(mockCategoryService, times(1)).getCategoryById("someCategory");
//    }
//
//    //This test case passes when you are able to fetch the list of all categories ordered by their name.
//    @Test
//    public void shouldGetAllCategoryOrderedByName() throws Exception {
//        final CategoryEntity categoryEntity = new CategoryEntity();
//        final String categoryEntityId = UUID.randomUUID().toString();
//        categoryEntity.setUuid(categoryEntityId);
//        categoryEntity.setCategoryName("sampleCategoryName");
//
//        when(mockCategoryService.getAllCategoriesOrderedByName()).thenReturn(Collections.singletonList(categoryEntity));
//
//        final String response = mockMvc
//                .perform(get("/category").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        final CategoriesListResponse categoriesListResponse = new ObjectMapper().readValue(response, CategoriesListResponse.class);
//        assertEquals(categoriesListResponse.getCategories().size(), 1);
//        assertEquals(categoriesListResponse.getCategories().get(0).getId().toString(), categoryEntityId);
//        assertEquals(categoriesListResponse.getCategories().get(0).getCategoryName(), "sampleCategoryName");
//
//        verify(mockCategoryService, times(1)).getAllCategoriesOrderedByName();
//    }
//
//    @Test
//    public void shouldNotGetAnyCategoryOrderedByNameIfItDoesNotExists() throws Exception {
//        when(mockCategoryService.getAllCategoriesOrderedByName()).thenReturn(Collections.emptyList());
//
//        final String response = mockMvc
//                .perform(get("/category").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        final CategoriesListResponse categoriesListResponse = new ObjectMapper().readValue(response, CategoriesListResponse.class);
//        assertNull(categoriesListResponse.getCategories());
//        verify(mockCategoryService, times(1)).getAllCategoriesOrderedByName();
//    }
//
//
//}