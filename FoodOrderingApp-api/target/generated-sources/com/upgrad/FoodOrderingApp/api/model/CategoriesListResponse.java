package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.FoodOrderingApp.api.model.CategoryListResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CategoriesListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-29T20:06:42.604+05:30")

public class CategoriesListResponse   {
  @JsonProperty("categories")
  @Valid
  private List<CategoryListResponse> categories = null;

  public CategoriesListResponse categories(List<CategoryListResponse> categories) {
    this.categories = categories;
    return this;
  }

  public CategoriesListResponse addCategoriesItem(CategoryListResponse categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * List of categories
   * @return categories
  **/
  @ApiModelProperty(value = "List of categories")

  @Valid

  public List<CategoryListResponse> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryListResponse> categories) {
    this.categories = categories;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoriesListResponse categoriesListResponse = (CategoriesListResponse) o;
    return Objects.equals(this.categories, categoriesListResponse.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoriesListResponse {\n");
    
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

