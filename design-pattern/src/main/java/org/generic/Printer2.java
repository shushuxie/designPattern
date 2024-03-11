package org.generic;

public class Printer2 <T extends Thing>{

    T cotent;

    public Printer2(T cotent) {
        this.cotent = cotent;
    }

    public void printer() {
        System.out.println(cotent);
    }

}
