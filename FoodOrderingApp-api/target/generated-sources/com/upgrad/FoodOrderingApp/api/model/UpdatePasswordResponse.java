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
 * UpdatePasswordResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-29T20:06:41.346+05:30")

public class UpdatePasswordResponse   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("status")
  private String status = null;

  public UpdatePasswordResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * uuid of the customer with updated password
   * @return id
  **/
  @ApiModelProperty(required = true, value = "uuid of the customer with updated password")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UpdatePasswordResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * message showing the status of the customer
   * @return status
  **/
  @ApiModelProperty(required = true, value = "message showing the status of the customer")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePasswordResponse updatePasswordResponse = (UpdatePasswordResponse) o;
    return Objects.equals(this.id, updatePasswordResponse.id) &&
        Objects.equals(this.status, updatePasswordResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePasswordResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

