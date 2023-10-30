package com.learning.oc.violation;

/**
 * this class doesnt follow the open closed principle
 * what if in future if you want to send otp via whatsapp?
 * you will need to change the method and corresponding test cases
 */
public class NotificationService {
    public void sendOTP(String medium) {
        if(medium.equalsIgnoreCase("emaill")) {
            System.out.println("Sent otp to to your email");
        } else if (medium.equalsIgnoreCase("mobile")) {
            System.out.println("Sent otp to your mobile");
        }
    }
}
