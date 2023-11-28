package com.learning;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "USER_DETAILS")
public class UserDetails {
    @EmbeddedId
    private FullName fullName;

    private long phoneNumber;

    @Transient
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Lob
    private String description;

    public UserDetails() {
    }

    public UserDetails(FullName fullName, long phoneNumber, String gender, String description) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.joiningDate = new Date();
        this.gender = gender;
        this.description = description;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate() {
        this.joiningDate = new Date();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
