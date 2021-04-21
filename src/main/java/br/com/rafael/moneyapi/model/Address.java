package br.com.rafael.moneyapi.model;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String publicPlace;
    private String number;
    private String complement;
    private String district;
    private String postalCode;
    private String city;
    private String state;

    public Address() {

    }

    public Address(String publicPlace, String number, String complement, String district, String postalCode, String city, String state) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getPublicPlace(), address.getPublicPlace()) && Objects.equals(getNumber(), address.getNumber()) && Objects.equals(getComplement(), address.getComplement()) && Objects.equals(getDistrict(), address.getDistrict()) && Objects.equals(getPostalCode(), address.getPostalCode()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getState(), address.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublicPlace(), getNumber(), getComplement(), getDistrict(), getPostalCode(), getCity(), getState());
    }
}
