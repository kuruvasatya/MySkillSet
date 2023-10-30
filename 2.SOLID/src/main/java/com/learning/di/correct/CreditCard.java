package com.learning.di.correct;

public class CreditCard implements BankCard {
    public void swipe(int amt) {
        System.out.println("debited " + amt + " from credit card");
    }
}
