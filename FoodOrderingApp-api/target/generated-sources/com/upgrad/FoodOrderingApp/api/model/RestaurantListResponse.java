package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.FoodOrderingApp.api.model.RestaurantList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RestaurantListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-26T22:40:01.329+05:30")

public class RestaurantListResponse   {
  @JsonProperty("restaurants")
  @Valid
  private List<RestaurantList> restaurants = null;

  public RestaurantListResponse restaurants(List<RestaurantList> restaurants) {
    this.restaurants = restaurants;
    return this;
  }

  public RestaurantListResponse addRestaurantsItem(RestaurantList restaurantsItem) {
    if (this.restaurants == null) {
      this.restaurants = new ArrayList<>();
    }
    this.restaurants.add(restaurantsItem);
    return this;
  }

  /**
   * List of restaurants
   * @return restaurants
  **/
  @ApiModelProperty(value = "List of restaurants")

  @Valid

  public List<RestaurantList> getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(List<RestaurantList> restaurants) {
    this.restaurants = restaurants;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestaurantListResponse restaurantListResponse = (RestaurantListResponse) o;
    return Objects.equals(this.restaurants, restaurantListResponse.restaurants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restaurants);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestaurantListResponse {\n");
    
    sb.append("    restaurants: ").append(toIndentedString(restaurants)).append("\n");
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

