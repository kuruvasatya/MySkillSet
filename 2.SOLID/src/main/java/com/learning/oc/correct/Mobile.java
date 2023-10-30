package com.learning.oc.correct;

public class Mobile implements NotificationServiceInterface{

    @Override
    public void sendOTP() {
        System.out.println("Sent otp via mobile");
    }
}
