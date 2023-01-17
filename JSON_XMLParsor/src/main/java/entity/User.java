package entity;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@XmlRootElement(name = "user")
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
