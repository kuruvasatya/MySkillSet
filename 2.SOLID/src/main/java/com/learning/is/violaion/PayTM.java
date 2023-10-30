package com.learning.is.violaion;

public class PayTM implements UPIPayments {

    @Override
    public void pay() {
        System.out.println("Paying users..");
    }

    @Override
    public void getScratchCard() {
        System.out.println("You won a scratch card");
    }

    @Override
    public void getCashBack() {
        System.out.println("You won cash back ...");
    }
}
