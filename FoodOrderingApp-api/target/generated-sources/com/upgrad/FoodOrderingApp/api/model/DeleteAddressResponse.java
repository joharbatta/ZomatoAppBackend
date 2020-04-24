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
 * DeleteAddressResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-24T18:46:26.639+05:30")

public class DeleteAddressResponse   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("status")
  private String status = null;

  public DeleteAddressResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * uuid of the deleted address
   * @return id
  **/
  @ApiModelProperty(required = true, value = "uuid of the deleted address")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public DeleteAddressResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * message showing the status of the deleted address
   * @return status
  **/
  @ApiModelProperty(required = true, value = "message showing the status of the deleted address")
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
    DeleteAddressResponse deleteAddressResponse = (DeleteAddressResponse) o;
    return Objects.equals(this.id, deleteAddressResponse.id) &&
        Objects.equals(this.status, deleteAddressResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteAddressResponse {\n");
    
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

