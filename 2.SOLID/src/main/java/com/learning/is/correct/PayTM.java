package com.learning.is.correct;

public class PayTM implements UPIPayments, CashBackManager {

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
