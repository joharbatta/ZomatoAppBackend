package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.FoodOrderingApp.api.model.ItemList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CategoryDetailsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-26T22:40:02.079+05:30")

public class CategoryDetailsResponse   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("category_name")
  private String categoryName = null;

  @JsonProperty("item_list")
  @Valid
  private List<ItemList> itemList = null;

  public CategoryDetailsResponse id(UUID id) {
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

  public CategoryDetailsResponse categoryName(String categoryName) {
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

  public CategoryDetailsResponse itemList(List<ItemList> itemList) {
    this.itemList = itemList;
    return this;
  }

  public CategoryDetailsResponse addItemListItem(ItemList itemListItem) {
    if (this.itemList == null) {
      this.itemList = new ArrayList<>();
    }
    this.itemList.add(itemListItem);
    return this;
  }

  /**
   * List of items
   * @return itemList
  **/
  @ApiModelProperty(value = "List of items")

  @Valid

  public List<ItemList> getItemList() {
    return itemList;
  }

  public void setItemList(List<ItemList> itemList) {
    this.itemList = itemList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryDetailsResponse categoryDetailsResponse = (CategoryDetailsResponse) o;
    return Objects.equals(this.id, categoryDetailsResponse.id) &&
        Objects.equals(this.categoryName, categoryDetailsResponse.categoryName) &&
        Objects.equals(this.itemList, categoryDetailsResponse.itemList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categoryName, itemList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDetailsResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    itemList: ").append(toIndentedString(itemList)).append("\n");
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

