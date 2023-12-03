package manytomany;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Laptop_4")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialId;
    private String brand;
    @ManyToMany(mappedBy = "laptop")
    List<Student> studentList;

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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "serialId=" + serialId +
                ", brand='" + brand + '\'' +
                '}';
    }
}
