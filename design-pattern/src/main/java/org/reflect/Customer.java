package org.reflect;

public class Customer {
    private String name;
    private String email;

    public Customer() {

    }
    public Customer(String name,String email) {
        this.name = name;
        this.email = email;
    }
    public void printCustomer() {
        System.out.println("customer"+name+"====="+email);
    }

    @ReflectAutowired
    public void printAble() {
        System.out.println("customer"+name+"====="+email);
    }
}
