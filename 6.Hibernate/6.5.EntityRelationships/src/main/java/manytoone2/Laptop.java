package manytoone2;

import javax.persistence.*;

@Entity(name="Laptop_2")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialId;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

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

    // need to be careful if we are printing the student object
    // then it might create circular dependency and lead to stackoverflow
    @Override
    public String toString() {
        return "Laptop{" +
                "serialId=" + serialId +
                ", brand='" + brand + '\'' +
                '}';
    }
}
