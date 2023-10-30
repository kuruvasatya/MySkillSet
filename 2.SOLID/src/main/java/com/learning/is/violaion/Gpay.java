package com.learning.is.violaion;

public class Gpay implements UPIPayments {
    @Override
    public void pay() {
        System.out.println("paying users...");
    }

    @Override
    public void getScratchCard() {
        System.out.println("You won a scratch card..");
    }

    /**
     * GPay doesnt want to give cashback, but we are forcing with our interface
     */

//    @Override
//    public void getCashBack() {
//
//    }
}
