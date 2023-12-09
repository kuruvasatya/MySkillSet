package batchsize;

import org.hibernate.annotations.BatchSize;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Customer1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    @BatchSize(size = 2)
    private List<Address> address;

    public Customer() {
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Customer(String name, List<Address> address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
