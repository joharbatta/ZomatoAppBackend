package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CategoryListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-29T20:06:42.604+05:30")

public class CategoryListResponse   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("category_name")
  private String categoryName = null;

  public CategoryListResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the category in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the category in a standard UUID format")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public CategoryListResponse categoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * Name of the category
   * @return categoryName
  **/
  @ApiModelProperty(value = "Name of the category")


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryListResponse categoryListResponse = (CategoryListResponse) o;
    return Objects.equals(this.id, categoryListResponse.id) &&
        Objects.equals(this.categoryName, categoryListResponse.categoryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categoryName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryListResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
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

