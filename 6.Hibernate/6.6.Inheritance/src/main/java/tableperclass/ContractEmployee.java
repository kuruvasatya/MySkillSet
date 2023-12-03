package tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class ContractEmployee extends Employee {
    int hoursWorked;
    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "hoursWorked=" + hoursWorked +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
