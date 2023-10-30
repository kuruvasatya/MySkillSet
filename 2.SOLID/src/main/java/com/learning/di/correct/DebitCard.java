package com.learning.di.correct;

public class DebitCard implements BankCard{
    public void swipe(int amt) {
        System.out.println("debited " + amt + " from debit card");
    }
}
