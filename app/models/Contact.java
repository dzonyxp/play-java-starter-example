package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private String id;
//    private String export_begin;
@JacksonXmlProperty(localName = "firstname")
    private String firstname;
    @JacksonXmlProperty(localName = "lastname")
    private String lastname;
    @JacksonXmlProperty(localName = "fullname")
    private String fullname;
    @JacksonXmlProperty(localName = "email")
    private String email;
    @JacksonXmlProperty(localName = "phone")
    private String phone;
    @JacksonXmlProperty(localName = "skype")
    private String skype;
    @JacksonXmlProperty(localName = "address")
    private String address;

    public Contact() {
    }

    public Contact(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", skype='" + skype + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    /*public String getExport_begin() {
            return export_begin;
        }

        public void setExport_begin(String export_begin) {
            this.export_begin = export_begin;
        }
    */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }
}
