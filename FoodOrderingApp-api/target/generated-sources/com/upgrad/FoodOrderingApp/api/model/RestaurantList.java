package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.FoodOrderingApp.api.model.RestaurantDetailsResponseAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RestaurantList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-29T20:06:42.061+05:30")

public class RestaurantList   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("restaurant_name")
  private String restaurantName = null;

  @JsonProperty("photo_URL")
  private String photoURL = null;

  @JsonProperty("customer_rating")
  private BigDecimal customerRating = null;

  @JsonProperty("average_price")
  private Integer averagePrice = null;

  @JsonProperty("number_customers_rated")
  private Integer numberCustomersRated = null;

  @JsonProperty("address")
  private RestaurantDetailsResponseAddress address = null;

  @JsonProperty("categories")
  private String categories = null;

  public RestaurantList id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the restaurant in a standard UUID format
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the restaurant in a standard UUID format")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public RestaurantList restaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
    return this;
  }

  /**
   * Name of the restaurant
   * @return restaurantName
  **/
  @ApiModelProperty(value = "Name of the restaurant")


  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public RestaurantList photoURL(String photoURL) {
    this.photoURL = photoURL;
    return this;
  }

  /**
   * URL for the picture of the restaurant
   * @return photoURL
  **/
  @ApiModelProperty(value = "URL for the picture of the restaurant")


  public String getPhotoURL() {
    return photoURL;
  }

  public void setPhotoURL(String photoURL) {
    this.photoURL = photoURL;
  }

  public RestaurantList customerRating(BigDecimal customerRating) {
    this.customerRating = customerRating;
    return this;
  }

  /**
   * Rating of the restaurant
   * @return customerRating
  **/
  @ApiModelProperty(value = "Rating of the restaurant")

  @Valid

  public BigDecimal getCustomerRating() {
    return customerRating;
  }

  public void setCustomerRating(BigDecimal customerRating) {
    this.customerRating = customerRating;
  }

  public RestaurantList averagePrice(Integer averagePrice) {
    this.averagePrice = averagePrice;
    return this;
  }

  /**
   * Average price for two people
   * @return averagePrice
  **/
  @ApiModelProperty(value = "Average price for two people")


  public Integer getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(Integer averagePrice) {
    this.averagePrice = averagePrice;
  }

  public RestaurantList numberCustomersRated(Integer numberCustomersRated) {
    this.numberCustomersRated = numberCustomersRated;
    return this;
  }

  /**
   * Number of customers rated the restaurant
   * @return numberCustomersRated
  **/
  @ApiModelProperty(value = "Number of customers rated the restaurant")


  public Integer getNumberCustomersRated() {
    return numberCustomersRated;
  }

  public void setNumberCustomersRated(Integer numberCustomersRated) {
    this.numberCustomersRated = numberCustomersRated;
  }

  public RestaurantList address(RestaurantDetailsResponseAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RestaurantDetailsResponseAddress getAddress() {
    return address;
  }

  public void setAddress(RestaurantDetailsResponseAddress address) {
    this.address = address;
  }

  public RestaurantList categories(String categories) {
    this.categories = categories;
    return this;
  }

  /**
   * List of categories
   * @return categories
  **/
  @ApiModelProperty(value = "List of categories")


  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
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
    RestaurantList restaurantList = (RestaurantList) o;
    return Objects.equals(this.id, restaurantList.id) &&
        Objects.equals(this.restaurantName, restaurantList.restaurantName) &&
        Objects.equals(this.photoURL, restaurantList.photoURL) &&
        Objects.equals(this.customerRating, restaurantList.customerRating) &&
        Objects.equals(this.averagePrice, restaurantList.averagePrice) &&
        Objects.equals(this.numberCustomersRated, restaurantList.numberCustomersRated) &&
        Objects.equals(this.address, restaurantList.address) &&
        Objects.equals(this.categories, restaurantList.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, restaurantName, photoURL, customerRating, averagePrice, numberCustomersRated, address, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestaurantList {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    restaurantName: ").append(toIndentedString(restaurantName)).append("\n");
    sb.append("    photoURL: ").append(toIndentedString(photoURL)).append("\n");
    sb.append("    customerRating: ").append(toIndentedString(customerRating)).append("\n");
    sb.append("    averagePrice: ").append(toIndentedString(averagePrice)).append("\n");
    sb.append("    numberCustomersRated: ").append(toIndentedString(numberCustomersRated)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

