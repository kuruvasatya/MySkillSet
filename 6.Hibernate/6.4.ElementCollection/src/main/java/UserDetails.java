

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @ElementCollection(fetch = FetchType.LAZY)
//    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Address> listOfAddress = new HashSet();

    public UserDetails() {
    }

    public UserDetails(int userId, Set<Address> listOfAddress) {
        this.userId = userId;
        this.listOfAddress = listOfAddress;
    }

    public UserDetails(Set<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Set<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", listOfAddress=" + listOfAddress +
                '}';
    }
}
