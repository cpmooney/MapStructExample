package org.example;

public class Household {
    public Household(String addressId, String[] personIds) {
        this.addressId = addressId;
        this.personIds = personIds;
    }

    public String addressId;
    public String[] personIds;

    public Address address;
    public Person[] people;
}
