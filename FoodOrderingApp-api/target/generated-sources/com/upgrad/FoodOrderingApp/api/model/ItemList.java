package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ItemList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-24T18:46:26.856+05:30")

public class ItemList   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("item_name")
  private String itemName = null;

  @JsonProperty("price")
  private Integer price = null;

  /**
   * Gets or Sets itemType
   */
  public enum ItemTypeEnum {
    VEG("VEG"),
    
    NON_VEG("NON_VEG");

    private String value;

    ItemTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ItemTypeEnum fromValue(String text) {
      for (ItemTypeEnum b : ItemTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("item_type")
  private ItemTypeEnum itemType = null;

  public ItemList id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the item in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the item in a standard UUID format")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ItemList itemName(String itemName) {
    this.itemName = itemName;
    return this;
  }

  /**
   * Name of the item
   * @return itemName
  **/
  @ApiModelProperty(value = "Name of the item")


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public ItemList price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Price of the item
   * @return price
  **/
  @ApiModelProperty(value = "Price of the item")


  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public ItemList itemType(ItemTypeEnum itemType) {
    this.itemType = itemType;
    return this;
  }

  /**
   * Get itemType
   * @return itemType
  **/
  @ApiModelProperty(value = "")


  public ItemTypeEnum getItemType() {
    return itemType;
  }

  public void setItemType(ItemTypeEnum itemType) {
    this.itemType = itemType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemList itemList = (ItemList) o;
    return Objects.equals(this.id, itemList.id) &&
        Objects.equals(this.itemName, itemList.itemName) &&
        Objects.equals(this.price, itemList.price) &&
        Objects.equals(this.itemType, itemList.itemType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, itemName, price, itemType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemList {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    itemType: ").append(toIndentedString(itemType)).append("\n");
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

