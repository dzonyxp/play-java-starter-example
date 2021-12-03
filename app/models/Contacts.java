package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
//import com.fasterxml.jackson.xml.annotate.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


import java.util.Arrays;
import java.util.List;
@JacksonXmlRootElement(localName = "contacts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contacts {
    @JacksonXmlProperty(localName = "contact")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Contact[] contactList;

    public Contacts() {
    }

    public Contact[] getContactList() {
        return contactList;
    }

    public void setContactList(Contact[] contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contactList=" + Arrays.toString(contactList) +
                '}';
    }
}
