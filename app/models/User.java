package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;
import services.LogInCheck;
import services.SignUpCheck;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.groups.Default;


@Entity(name="User")
public class User extends Model{


    @Id
    @Constraints.Required(groups = {SignUpCheck.class, Default.class, LogInCheck.class})
    @Constraints.Email(groups = {Default.class, SignUpCheck.class, LogInCheck.class})
    private String email;
     @Constraints.Required(groups = {SignUpCheck.class, Default.class})
    private String name;
    private String password;
    @OneToOne(mappedBy = "user")
    private Address address;


    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
    public static Finder<String,User> find = new Finder<>(User.class);


    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
