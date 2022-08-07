package models;

import enums.*;

import java.util.Objects;

public class Lead {

    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address;
    private final String street;
    private final String province;
    private final String middleName;
    private final String suffix;
    private final String title;
    private final String email;
    private final String phone;
    private final String mobilePhone;
    private final Salutation salutation;
    private final Rating rating;
    private final Industry industry;
    private final LeadStatus leadStatus;
    private final LeadSource leadSource;
    private final String postalCode;
    private final String numberOfEmployees;
    private final String webSite;
    private final String fullName;

    private Lead(Lead.LeadBuilder leadBuilder) {
        this.leadStatus = leadBuilder.leadStatus;
        this.salutation = leadBuilder.salutation;
        this.firstName = leadBuilder.firstName;
        this.lastName = leadBuilder.lastName;
        this.middleName = leadBuilder.middleName;
        this.suffix = leadBuilder.suffix;
        this.title = leadBuilder.title;
        this.email = leadBuilder.email;
        this.phone = leadBuilder.phone;
        this.mobilePhone = leadBuilder.mobilePhone;
        this.rating = leadBuilder.rating;
        this.company = leadBuilder.company;
        this.industry = leadBuilder.industry;
        this.numberOfEmployees = leadBuilder.numberOfEmployees;
        this.leadSource = leadBuilder.leadSource;
        this.address = leadBuilder.address;
        this.street = leadBuilder.street;
        this.province = leadBuilder.province;
        this.postalCode = leadBuilder.postalCode;
        this.webSite = leadBuilder.webSite;
        this.fullName = leadBuilder.fullName;
    }

    public String getFullName() {
        if (this.fullName != null) {
            return this.fullName;
        } else {
            return (this.salutation.getName() + " " + this.firstName + " " + this.lastName).trim();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return Objects.equals(getFullName(), lead.getFullName()) && Objects.equals(company, lead.company) && Objects.equals(address, lead.address) && Objects.equals(street, lead.street) && Objects.equals(province, lead.province) && Objects.equals(middleName, lead.middleName) && Objects.equals(suffix, lead.suffix) && Objects.equals(title, lead.title) && Objects.equals(email, lead.email) && Objects.equals(phone, lead.phone) && Objects.equals(mobilePhone, lead.mobilePhone) && salutation == lead.salutation && rating == lead.rating && industry == lead.industry && leadStatus == lead.leadStatus && leadSource == lead.leadSource && Objects.equals(postalCode, lead.postalCode) && Objects.equals(numberOfEmployees, lead.numberOfEmployees) && Objects.equals(webSite, lead.webSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, company, address, street, province, middleName, suffix, title, email, phone, mobilePhone, salutation, rating, industry, leadStatus, leadSource, postalCode, numberOfEmployees, webSite);
    }

    @Override
    public String toString() {
        return "Lead{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", street='" + street + '\'' +
                ", province='" + province + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", salutation=" + salutation +
                ", rating=" + rating +
                ", industry=" + industry +
                ", leadStatus=" + leadStatus +
                ", leadSource=" + leadSource +
                ", postalCode='" + postalCode + '\'' +
                ", numberOfEmployees='" + numberOfEmployees + '\'' +
                ", webSite='" + webSite + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
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

    public Rating getRating() {
        return rating;
    }

    public Industry getIndustry() {
        return industry;
    }

    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getWebSite() {
        return webSite;
    }

    public static class LeadBuilder {

        private final String company;
        private final LeadStatus leadStatus;
        private String lastName;
        private String firstName;
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
        private LeadSource leadSource;
        private String postalCode;
        private String numberOfEmployees;
        private String webSite;
        private String fullName;


        public LeadBuilder(String company, LeadStatus leadStatus) {
            this.company = company;
            this.leadStatus = leadStatus;
        }

        public Lead build() {
            return new Lead(this);
        }

        public Lead.LeadBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Lead.LeadBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Lead.LeadBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Lead.LeadBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Lead.LeadBuilder street(String street) {
            this.street = street;
            return this;
        }

        public Lead.LeadBuilder province(String province) {
            this.province = province;
            return this;
        }

        public Lead.LeadBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Lead.LeadBuilder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public Lead.LeadBuilder title(String title) {
            this.title = title;
            return this;
        }

        public Lead.LeadBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Lead.LeadBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Lead.LeadBuilder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Lead.LeadBuilder salutation(Salutation salutation) {
            this.salutation = salutation;
            return this;
        }

        public Lead.LeadBuilder rating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Lead.LeadBuilder industry(Industry industry) {
            this.industry = industry;
            return this;
        }

        public Lead.LeadBuilder leadSource(LeadSource leadSource) {
            this.leadSource = leadSource;
            return this;
        }

        public Lead.LeadBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Lead.LeadBuilder numberOfEmployees(String numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
            return this;
        }

        public Lead.LeadBuilder webSite(String webSite) {
            this.webSite = webSite;
            return this;
        }
    }
}


