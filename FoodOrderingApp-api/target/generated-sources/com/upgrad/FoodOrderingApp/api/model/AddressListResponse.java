package com.upgrad.FoodOrderingApp.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.upgrad.FoodOrderingApp.api.model.AddressList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddressListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-26T22:40:01.764+05:30")

public class AddressListResponse   {
  @JsonProperty("addresses")
  @Valid
  private List<AddressList> addresses = null;

  public AddressListResponse addresses(List<AddressList> addresses) {
    this.addresses = addresses;
    return this;
  }

  public AddressListResponse addAddressesItem(AddressList addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * List of addresses
   * @return addresses
  **/
  @ApiModelProperty(value = "List of addresses")

  @Valid

  public List<AddressList> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<AddressList> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressListResponse addressListResponse = (AddressListResponse) o;
    return Objects.equals(this.addresses, addressListResponse.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressListResponse {\n");
    
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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

