package models;

import enums.Industry;
import enums.Type;

import java.util.Objects;

public class Account {

    private final String phone;
    private final Industry industry;
    private final Type type;
    private final String accountName;
    private final String description;
    private final String webSite;
    private final String parentAccount;
    private final String employees;
    private final String billingAddress;
    private final String shippingAddress;
    private final String billingStreet;
    private final String shippingStreet;
    private final String shippingPostalCode;
    private final String billingPostalCode;
    private final String shippingProvince;
    private final String billingProvince;

    private Account(AccountBuilder accountBuilder) {

        this.webSite = accountBuilder.webSite;
        this.phone = accountBuilder.phone;
        this.industry = accountBuilder.industry;
        this.accountName = accountBuilder.accountName;
        this.type = accountBuilder.type;
        this.description = accountBuilder.description;
        this.parentAccount = accountBuilder.parentAccount;
        this.employees = accountBuilder.employees;
        this.billingAddress = accountBuilder.billingAddress;
        this.shippingAddress = accountBuilder.shippingAddress;
        this.billingStreet = accountBuilder.billingStreet;
        this.shippingStreet = accountBuilder.shippingStreet;
        this.shippingProvince = accountBuilder.shippingProvince;
        this.billingProvince = accountBuilder.billingProvince;
        this.shippingPostalCode = accountBuilder.shippingPostalCode;
        this.billingPostalCode = accountBuilder.billingPostalCode;
    }

    public String getPhone() {
        return phone;
    }

    public Industry getIndustry() {
        return industry;
    }

    public Type getType() {
        return type;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getDescription() {
        return description;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public String getEmployees() {
        return employees;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public String getShippingProvince() {
        return shippingProvince;
    }

    public String getBillingProvince() {
        return billingProvince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(phone, account.phone) && industry == account.industry && type == account.type && Objects.equals(accountName, account.accountName) && Objects.equals(description, account.description) && Objects.equals(webSite, account.webSite) && Objects.equals(parentAccount, account.parentAccount) && Objects.equals(employees, account.employees) && Objects.equals(billingAddress, account.billingAddress) && Objects.equals(shippingAddress, account.shippingAddress) && Objects.equals(billingStreet, account.billingStreet) && Objects.equals(shippingStreet, account.shippingStreet) && Objects.equals(shippingPostalCode, account.shippingPostalCode) && Objects.equals(billingPostalCode, account.billingPostalCode) && Objects.equals(shippingProvince, account.shippingProvince) && Objects.equals(billingProvince, account.billingProvince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, industry, type, accountName, description, webSite, parentAccount, employees, billingAddress, shippingAddress, billingStreet, shippingStreet, shippingPostalCode, billingPostalCode, shippingProvince, billingProvince);
    }

    @Override
    public String toString() {
        return "Lead{" +
                ", phone='" + phone + '\'' +
                ", industry=" + industry +
                ", type=" + type +
                ", accountName='" + accountName + '\'' +
                ", description='" + description + '\'' +
                ", webSite='" + webSite + '\'' +
                ", parentAccount='" + parentAccount + '\'' +
                ", employees='" + employees + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingStreet='" + billingStreet + '\'' +
                ", shippingStreet='" + shippingStreet + '\'' +
                ", shippingPostalCode='" + shippingPostalCode + '\'' +
                ", billingPostalCode='" + billingPostalCode + '\'' +
                ", shippingProvince='" + shippingProvince + '\'' +
                ", billingProvince='" + billingProvince + '\'' +
                '}';
    }

    public static class AccountBuilder {

        private final String accountName;
        private String phone;
        private Industry industry;
        private Type type;
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


        public AccountBuilder(String accountName) {
            this.accountName = accountName;

        }

        public Account build() {
            return new Account(this);
        }

        public Account.AccountBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Account.AccountBuilder industry(Industry industry) {
            this.industry = industry;
            return this;
        }

        public Account.AccountBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public Account.AccountBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Account.AccountBuilder webSite(String webSite) {
            this.webSite = webSite;
            return this;
        }

        public Account.AccountBuilder parentAccount(String parentAccount) {
            this.parentAccount = parentAccount;
            return this;
        }

        public Account.AccountBuilder employees(String employees) {
            this.employees = employees;
            return this;
        }

        public Account.AccountBuilder billingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public Account.AccountBuilder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Account.AccountBuilder billingStreet(String billingStreet) {
            this.billingStreet = billingStreet;
            return this;
        }

        public Account.AccountBuilder shippingStreet(String shippingStreet) {
            this.shippingStreet = shippingStreet;
            return this;
        }

        public Account.AccountBuilder shippingPostalCode(String shippingPostalCode) {
            this.shippingPostalCode = shippingPostalCode;
            return this;
        }

        public Account.AccountBuilder billingPostalCode(String billingPostalCode) {
            this.billingPostalCode = billingPostalCode;
            return this;
        }

        public Account.AccountBuilder shippingProvince(String shippingProvince) {
            this.shippingProvince = shippingProvince;
            return this;
        }

        public Account.AccountBuilder billingProvince(String billingProvince) {
            this.billingProvince = billingProvince;
            return this;
        }


    }

}

