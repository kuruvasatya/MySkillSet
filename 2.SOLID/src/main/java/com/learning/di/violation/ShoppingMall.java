package com.learning.di.violation;

/**
 * this violates the DI principle, so every time we want to change the payment mode, we need
 * to keep updating the ShoppingMall class
 */
public class ShoppingMall {
    DebitCard card = new DebitCard();
    public void buyItem() {
        card.swipe(100);
    }
    public static void main(String args[]) {
        ShoppingMall s = new ShoppingMall();
        s.buyItem();;
    }
}
