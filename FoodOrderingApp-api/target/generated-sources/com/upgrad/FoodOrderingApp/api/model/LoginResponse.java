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
 * LoginResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-29T20:06:41.346+05:30")

public class LoginResponse   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("first_name")
  private String firstName = null;

  @JsonProperty("last_name")
  private String lastName = null;

  @JsonProperty("email_address")
  private String emailAddress = null;

  @JsonProperty("contact_number")
  private String contactNumber = null;

  public LoginResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * uuid for the customer authentication after he signs in.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "uuid for the customer authentication after he signs in.")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LoginResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * message to show the status of the signed in customer
   * @return message
  **/
  @ApiModelProperty(required = true, value = "message to show the status of the signed in customer")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LoginResponse firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the new customer
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "First name of the new customer")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public LoginResponse lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the new customer
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "Last name of the new customer")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LoginResponse emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Email address of the new customer
   * @return emailAddress
  **/
  @ApiModelProperty(required = true, value = "Email address of the new customer")
  @NotNull


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public LoginResponse contactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  /**
   * Contact Number of the new customer
   * @return contactNumber
  **/
  @ApiModelProperty(required = true, value = "Contact Number of the new customer")
  @NotNull


  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginResponse loginResponse = (LoginResponse) o;
    return Objects.equals(this.id, loginResponse.id) &&
        Objects.equals(this.message, loginResponse.message) &&
        Objects.equals(this.firstName, loginResponse.firstName) &&
        Objects.equals(this.lastName, loginResponse.lastName) &&
        Objects.equals(this.emailAddress, loginResponse.emailAddress) &&
        Objects.equals(this.contactNumber, loginResponse.contactNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message, firstName, lastName, emailAddress, contactNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
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

