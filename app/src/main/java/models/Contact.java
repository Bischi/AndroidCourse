package models;

import java.io.Serializable;

public class Contact implements Serializable {

    private String _firstname;
    private String _lastname;
    private String _phoneNumber;
    private String _email;
    private String _streetName;
    private int _streetNumber;
    private int _postcode;
    private String _city;
    private String _country;


    public Contact(String firstname, String lastname) {
        _firstname = firstname;
        _lastname = lastname;
    }

    public String getFirstname() {
        return _firstname;
    }

    public void setFirstname(String firstname) {
        _firstname = firstname;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        _lastname = lastname;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getStreetName() {
        return _streetName;
    }

    public void setStreetName(String streetName) {
        _streetName = streetName;
    }

    public int getStreetNumber() {
        return _streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        _streetNumber = streetNumber;
    }

    public int getPostcode() {
        return _postcode;
    }

    public void setPostcode(int postcode) {
        _postcode = postcode;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    @Override
    public String toString() {
        return _firstname + " " + _lastname + " Email: " + _email;
    }
}
