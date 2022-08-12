package models;
import enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lead {

    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String street;
    private String province;
    private String middleName;
    private String suffix;
    private String title;
    private String email;
    private String phone;
    private String mobilePhone;
    private Salutation salutation;
    private Rating rating;
    private Industry industry;
    private LeadStatus leadStatus;
    private LeadSource leadSource;
    private String postalCode;
    private String numberOfEmployees;
    private String webSite;
    private String fullName;

}


