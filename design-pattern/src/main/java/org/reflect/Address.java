package org.reflect;

public class Address {
    private String street;
    public String postCode;

    public Address() {

    }

    public Address(String street, String postCode) {
        this.street = street;
        this.postCode = postCode;
    }

    public void printAddress() {
        System.out.println("address street"+street+"-----"+postCode);
    }
}
