package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SaveAddressRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-29T20:06:42.362+05:30")

public class SaveAddressRequest   {
  @JsonProperty("flat_building_name")
  private String flatBuildingName = null;

  @JsonProperty("locality")
  private String locality = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("pincode")
  private String pincode = null;

  @JsonProperty("state_uuid")
  private String stateUuid = null;

  public SaveAddressRequest flatBuildingName(String flatBuildingName) {
    this.flatBuildingName = flatBuildingName;
    return this;
  }

  /**
   * Flat and building address
   * @return flatBuildingName
  **/
  @ApiModelProperty(required = true, value = "Flat and building address")
  @NotNull


  public String getFlatBuildingName() {
    return flatBuildingName;
  }

  public void setFlatBuildingName(String flatBuildingName) {
    this.flatBuildingName = flatBuildingName;
  }

  public SaveAddressRequest locality(String locality) {
    this.locality = locality;
    return this;
  }

  /**
   * Locality of the address
   * @return locality
  **/
  @ApiModelProperty(required = true, value = "Locality of the address")
  @NotNull


  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public SaveAddressRequest city(String city) {
    this.city = city;
    return this;
  }

  /**
   * City of the address
   * @return city
  **/
  @ApiModelProperty(required = true, value = "City of the address")
  @NotNull


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public SaveAddressRequest pincode(String pincode) {
    this.pincode = pincode;
    return this;
  }

  /**
   * pincode of the address
   * @return pincode
  **/
  @ApiModelProperty(required = true, value = "pincode of the address")
  @NotNull


  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public SaveAddressRequest stateUuid(String stateUuid) {
    this.stateUuid = stateUuid;
    return this;
  }

  /**
   * Id of the state
   * @return stateUuid
  **/
  @ApiModelProperty(required = true, value = "Id of the state")
  @NotNull


  public String getStateUuid() {
    return stateUuid;
  }

  public void setStateUuid(String stateUuid) {
    this.stateUuid = stateUuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaveAddressRequest saveAddressRequest = (SaveAddressRequest) o;
    return Objects.equals(this.flatBuildingName, saveAddressRequest.flatBuildingName) &&
        Objects.equals(this.locality, saveAddressRequest.locality) &&
        Objects.equals(this.city, saveAddressRequest.city) &&
        Objects.equals(this.pincode, saveAddressRequest.pincode) &&
        Objects.equals(this.stateUuid, saveAddressRequest.stateUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flatBuildingName, locality, city, pincode, stateUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaveAddressRequest {\n");
    
    sb.append("    flatBuildingName: ").append(toIndentedString(flatBuildingName)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
    sb.append("    stateUuid: ").append(toIndentedString(stateUuid)).append("\n");
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

