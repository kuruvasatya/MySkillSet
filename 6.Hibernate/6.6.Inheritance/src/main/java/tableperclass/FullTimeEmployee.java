package tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
    String benefits;

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", benefits='" + benefits + '\'' +
                '}';
    }
}
