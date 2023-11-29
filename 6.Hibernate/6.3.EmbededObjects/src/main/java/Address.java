import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "CITY_NAME")
    String city;
    @Column(name = "PINCODE")
    int pincode;

    public Address() {
    }

    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pincde=" + pincode +
                '}';
    }
}
