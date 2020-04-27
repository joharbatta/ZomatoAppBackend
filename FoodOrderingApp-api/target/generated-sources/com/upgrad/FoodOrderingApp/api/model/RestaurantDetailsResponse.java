package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.FoodOrderingApp.api.model.CategoryList;
import com.upgrad.FoodOrderingApp.api.model.RestaurantDetailsResponseAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Restaurant details
 */
@ApiModel(description = "Restaurant details")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-26T22:40:01.329+05:30")

public class RestaurantDetailsResponse   {
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
  @Valid
  private List<CategoryList> categories = null;

  public RestaurantDetailsResponse id(UUID id) {
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

  public RestaurantDetailsResponse restaurantName(String restaurantName) {
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

  public RestaurantDetailsResponse photoURL(String photoURL) {
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

  public RestaurantDetailsResponse customerRating(BigDecimal customerRating) {
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

  public RestaurantDetailsResponse averagePrice(Integer averagePrice) {
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

  public RestaurantDetailsResponse numberCustomersRated(Integer numberCustomersRated) {
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

  public RestaurantDetailsResponse address(RestaurantDetailsResponseAddress address) {
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

  public RestaurantDetailsResponse categories(List<CategoryList> categories) {
    this.categories = categories;
    return this;
  }

  public RestaurantDetailsResponse addCategoriesItem(CategoryList categoriesItem) {
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

  public List<CategoryList> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryList> categories) {
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
    RestaurantDetailsResponse restaurantDetailsResponse = (RestaurantDetailsResponse) o;
    return Objects.equals(this.id, restaurantDetailsResponse.id) &&
        Objects.equals(this.restaurantName, restaurantDetailsResponse.restaurantName) &&
        Objects.equals(this.photoURL, restaurantDetailsResponse.photoURL) &&
        Objects.equals(this.customerRating, restaurantDetailsResponse.customerRating) &&
        Objects.equals(this.averagePrice, restaurantDetailsResponse.averagePrice) &&
        Objects.equals(this.numberCustomersRated, restaurantDetailsResponse.numberCustomersRated) &&
        Objects.equals(this.address, restaurantDetailsResponse.address) &&
        Objects.equals(this.categories, restaurantDetailsResponse.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, restaurantName, photoURL, customerRating, averagePrice, numberCustomersRated, address, categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestaurantDetailsResponse {\n");
    
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

