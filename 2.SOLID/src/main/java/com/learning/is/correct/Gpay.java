package com.learning.is.correct;

public class Gpay implements UPIPayments {
    @Override
    public void pay() {
        System.out.println("paying users...");
    }

    @Override
    public void getScratchCard() {
        System.out.println("You won a scratch card..");
    }

}
