package com.learning.is;

public class Gpay implements UPIPayments{
    @Override
    public void pay() {
        System.out.println("paying users...");
    }

    @Override
    public void getScratchCard() {
        System.out.println("You won a scratch card..");
    }

    /**
     * GPay doesnt want to give cashback, but paytm wants to do it, so we can not place
     * getCashBack inside the UPIPayments interface
     */

//    @Override
//    public void getCashBack() {
//
//    }
}
