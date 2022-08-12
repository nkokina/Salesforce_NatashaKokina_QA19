package models;

import enums.Salutation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    private String firstName;
    private String lastName;
    private String street;
    private String province;
    private String middleName;
    private String suffix;
    private String title;
    private String email;
    private String phone;
    private String mobilePhone;
    private Salutation salutation;
    private String accountName;
    private String postalCode;
    private String description;
    private String reportsTo;
    private String department;
    private String mailingAddress;
    private String fax;

}


