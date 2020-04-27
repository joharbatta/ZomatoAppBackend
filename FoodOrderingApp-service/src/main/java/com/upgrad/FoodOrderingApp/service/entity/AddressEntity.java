package com.upgrad.FoodOrderingApp.service.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "deleteAddressById", query = "delete from AddressEntity a where a.uuid=:addressuuid"),
        @NamedQuery(name = "archiveAddressById", query = "update AddressEntity a set a.active = 0 where a.uuid=:addressuuid"),
        @NamedQuery(name = "getAddressById", query = "select a from AddressEntity a where a.uuid=:addressuuid")
})

@Entity
@Table(name="address")
public class AddressEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @Size(max = 200)
    private String uuid;

    @Column(name = "FLAT_BUIL_NUMBER")
    @Size(max = 255)
    private String flat_buil_number;

    @Column(name = "LOCALITY")
    @Size(max = 255)
    private String locality;

    @Column(name = "CITY")
    @Size(max = 30)
    private String city;

    @Column(name = "PINCODE")
    @Size(max = 30)
    private String pincode;

    @Column(name = "ACTIVE")
    private int active;

//    @OneToOne(mappedBy = "addressEntity")
//    private RestaurantEntity restaurantEntity;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "STATE_ID")
    private StateEntity stateEntity;

    @ManyToMany(mappedBy = "address" ,cascade= CascadeType.ALL)
    private List<CustomerEntity> customer = new ArrayList<CustomerEntity>();

    public List<CustomerEntity> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerEntity> customer) {
        this.customer = customer;
    }

    public StateEntity getStateEntity() {
        return stateEntity;
    }

    public void setStateEntity(StateEntity stateEntity) {
        this.stateEntity = stateEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFlat_buil_number() {
        return flat_buil_number;
    }

    public void setFlat_buil_number(String flat_buil_number) {
        this.flat_buil_number = flat_buil_number;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

//    public RestaurantEntity getRestaurantEntity() {
//        return restaurantEntity;
//    }
//
//    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
//        this.restaurantEntity = restaurantEntity;
//    }
}
