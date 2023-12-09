package batchsize;

import javax.persistence.*;

@Entity
@Table(name ="Address1")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pincode;
    private String city;
    @ManyToOne
    private Customer customer;

    public Address() {
    }

    public Address(int pincode, String city) {
        this.pincode = pincode;
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                '}';
    }
}
