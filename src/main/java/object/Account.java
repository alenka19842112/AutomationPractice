package object;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String firstName;
    private String lastName;
    private String password;
    private String dateOfBirthDay;
    private String dateOfBirthMonth;
    private String dateOfBirthYear;
    private String company;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String information;
    private String mobilePhone;

    public Account(String address) {
        this.address = address;
    }
}
