package be.howest.addressbook.be.howest.addressbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String _firstname;
    private String _lastname;
    private String _title;

    public String getFirstname() {
        return _firstname;
    }

    @JsonSetter("FirstName")
    public void setFirstname(String firstname) {
        _firstname = firstname;
    }

    public String getLastname() {
        return _lastname;
    }

    @JsonSetter("LastName")
    public void setLastname(String lastname) {
        _lastname = lastname;
    }

    public String getTitle() {
        return _title;
    }

    @JsonSetter("Title")
    public void setTitle(String title) {
        _title = title;
    }
}