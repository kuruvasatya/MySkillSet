package com.learning;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FullName implements Serializable {
    String fname;
    String lname;

    public FullName() {
    }

    public FullName(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
