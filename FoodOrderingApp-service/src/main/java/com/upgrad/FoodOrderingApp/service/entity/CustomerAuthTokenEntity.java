package com.upgrad.FoodOrderingApp.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;


@NamedQueries({
	@NamedQuery(name = "userAuthTokenByAccessToken", query = "select ut from CustomerAuthTokenEntity ut where ut.accessToken =:accessToken"),
	@NamedQuery(name = "userAuthTokenByUUID", query = "select ut from CustomerAuthTokenEntity ut where ut.uuid =:uuid")})
@Entity
@Table(name = "customer_auth")
public class CustomerAuthTokenEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "UUID")
	private String uuid;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@Column(name = "access_token")
	@NotNull
	private String accessToken;

	@Column(name = "login_at")
	@NotNull
	private ZonedDateTime loginAt;

	@Column(name = "logout_at")
	private ZonedDateTime logoutAt;

	@Column(name = "expires_at")
	@NotNull
	private ZonedDateTime expiresAt;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerEntity getUser() {
		return customer;
	}

	public void setUser(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public ZonedDateTime getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(ZonedDateTime loginAt) {
		this.loginAt = loginAt;
	}

	public ZonedDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(ZonedDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public ZonedDateTime getLogoutAt() {
		return logoutAt;
	}

	public void setLogoutAt(ZonedDateTime logoutAt) {
		this.logoutAt = logoutAt;
	}

	@Override
	public boolean equals(Object obj) {
		return new EqualsBuilder().append(this, obj).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this).hashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
