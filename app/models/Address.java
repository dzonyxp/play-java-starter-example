package models;


import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Address")
public class Address extends Model {

    private String city;
    private String state;
    private String street;
    //private Integer streetNumber;
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Address(String city, String state, String street) {
        this.city = city;
        this.state = state;
        this.street = street;
        //this.streetNumber = streetNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        //this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    /*public Integer getStreetNumber() {
        return streetNumber;
    }*/
}
