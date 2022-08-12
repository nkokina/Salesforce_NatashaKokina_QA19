package models;

import enums.Industry;
import enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private String phone;
    private Industry industry;
    private Type type;
    private String accountName;
    private String description;
    private String webSite;
    private String parentAccount;
    private String employees;
    private String billingAddress;
    private String shippingAddress;
    private String billingStreet;
    private String shippingStreet;
    private String shippingPostalCode;
    private String billingPostalCode;
    private String shippingProvince;
    private String billingProvince;

}

