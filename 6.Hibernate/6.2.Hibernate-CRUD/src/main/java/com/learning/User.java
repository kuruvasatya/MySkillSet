package com.learning;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="User")
public class User {
    @EmbeddedId
    private FullName fullName;
    long phoneNo;

    public User() {
    }

    public User(FullName fullName, long phoneNo) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName=" + fullName +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
