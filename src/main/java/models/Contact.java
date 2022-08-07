package models;

import enums.Salutation;

import java.util.Objects;

public class Contact {
    private final String firstName;
    private final String lastName;
    private final String street;
    private final String province;
    private final String middleName;
    private final String suffix;
    private final String title;
    private final String email;
    private final String phone;
    private final String mobilePhone;
    private final Salutation salutation;
    private final String accountName;
    private final String postalCode;
    private final String description;
    private final String reportsTo;
    private final String department;
    private final String mailingAddress;
    private final String fax;

    private Contact(Contact.ContactBuilder contactBuilder) {
        this.salutation = contactBuilder.salutation;
        this.firstName = contactBuilder.firstName;
        this.lastName = contactBuilder.lastName;
        this.middleName = contactBuilder.middleName;
        this.suffix = contactBuilder.suffix;
        this.title = contactBuilder.title;
        this.email = contactBuilder.email;
        this.phone = contactBuilder.phone;
        this.mobilePhone = contactBuilder.mobilePhone;
        this.street = contactBuilder.street;
        this.province = contactBuilder.province;
        this.postalCode = contactBuilder.postalCode;
        this.accountName = contactBuilder.accountName;
        this.reportsTo = contactBuilder.reportsTo;
        this.department = contactBuilder.department;
        this.fax = contactBuilder.fax;
        this.description = contactBuilder.description;
        this.mailingAddress = contactBuilder.mailingAddress;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", province='" + province + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", salutation=" + salutation +
                ", accountName='" + accountName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", description='" + description + '\'' +
                ", reportsTo='" + reportsTo + '\'' +
                ", department='" + department + '\'' +
                ", mailingAddress='" + mailingAddress + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(street, contact.street) && Objects.equals(province, contact.province) && Objects.equals(middleName, contact.middleName) && Objects.equals(suffix, contact.suffix) && Objects.equals(title, contact.title) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone) && Objects.equals(mobilePhone, contact.mobilePhone) && salutation == contact.salutation && Objects.equals(accountName, contact.accountName) && Objects.equals(postalCode, contact.postalCode) && Objects.equals(description, contact.description) && Objects.equals(reportsTo, contact.reportsTo) && Objects.equals(department, contact.department) && Objects.equals(mailingAddress, contact.mailingAddress) && Objects.equals(fax, contact.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, street, province, middleName, suffix, title, email, phone, mobilePhone, salutation, accountName, postalCode, description, reportsTo, department, mailingAddress, fax);
    }

    public String getFax() {
        return fax;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getProvince() {
        return province;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDescription() {
        return description;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public String getDepartment() {
        return department;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public static class ContactBuilder {

        private final String lastName;
        private final String accountName;
        private String firstName;
        private String street;
        private String province;
        private String middleName;
        private String suffix;
        private String title;
        private String email;
        private String phone;
        private String mobilePhone;
        private Salutation salutation;
        private String postalCode;
        private String description;
        private String reportsTo;
        private String department;
        private String mailingAddress;
        private String fax;


        public ContactBuilder(String lastName, String accountName) {
            this.lastName = lastName;
            this.accountName = accountName;
        }

        public Contact build() {
            return new Contact(this);
        }

        public Contact.ContactBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Contact.ContactBuilder street(String street) {
            this.street = street;
            return this;
        }

        public Contact.ContactBuilder province(String province) {
            this.province = province;
            return this;
        }

        public Contact.ContactBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Contact.ContactBuilder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public Contact.ContactBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Contact.ContactBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Contact.ContactBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Contact.ContactBuilder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Contact.ContactBuilder salutation(Salutation salutation) {
            this.salutation = salutation;
            return this;
        }

        public Contact.ContactBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Contact.ContactBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Contact.ContactBuilder reportsTo(String reportsTo) {
            this.reportsTo = reportsTo;
            return this;
        }

        public Contact.ContactBuilder department(String department) {
            this.department = department;
            return this;
        }

        public Contact.ContactBuilder mailingAddress(String mailingAddress) {
            this.mailingAddress = mailingAddress;
            return this;
        }

        public Contact.ContactBuilder fax(String fax) {
            this.fax = fax;
            return this;
        }

    }
}


