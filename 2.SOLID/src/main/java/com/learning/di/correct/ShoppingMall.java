package com.learning.di.correct;

public class ShoppingMall {
    BankCard card;

    ShoppingMall(BankCard card) {
        this.card = card;
    }

    public void buyItem() {
        this.card.swipe(100);
    }

    public static void main(String args[]) {
        DebitCard card = new DebitCard();
        ShoppingMall s = new ShoppingMall(card);
        s.buyItem();

        CreditCard card1 = new CreditCard();
        ShoppingMall s1 = new ShoppingMall(card1);
        s1.buyItem();
    }
}
