package manytoone;

import javax.persistence.*;

@Entity(name = "LAPTOP_1")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int serialId;
    String brand;
    @ManyToOne(fetch = FetchType.EAGER)
    Student student;

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "serialId=" + serialId +
                ", brand='" + brand + '\'' +
                ", student=" + student +
                '}';
    }
}
