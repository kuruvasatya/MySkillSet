import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "CURRENT_CITY_NAME")),
            @AttributeOverride(name = "pincode", column = @Column(name = "CURRENT_PINCODE"))
    })
    Address currentAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "PERMANENT_CITY_NAME")),
            @AttributeOverride(name = "pincode", column = @Column(name = "PERMANENT_PINCODE"))
    })
    Address permanentAddress;

    public Employee() {
    }

    public Employee(Address currentAddress, Address permanentAddress) {
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", currentAddress=" + currentAddress +
                ", permanentAddress=" + permanentAddress +
                '}';
    }
}
