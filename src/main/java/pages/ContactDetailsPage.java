package pages;

import elements.LightningFormattedElement;
import enums.Salutation;
import models.Contact;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {
    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public Contact getContactInfo() {
        String lastName = new LightningFormattedElement(driver, "Last Name").getText();
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        Contact.ContactBuilder contactBuilder = new Contact.ContactBuilder(lastName, accountName);
        String middleName = new LightningFormattedElement(driver, "Middle Name").getText();
        if (middleName != "") {
            contactBuilder.middleName(middleName);
        }
        String suffix = new LightningFormattedElement(driver, "Suffix").getText();
        if (suffix != "") {
            contactBuilder.suffix(suffix);
        }
        String title = new LightningFormattedElement(driver, "Title").getText();
        if (title != "") {
            contactBuilder.title(title);
        }
        String email = new LightningFormattedElement(driver, "Email").getText();
        if (email != "") {
            contactBuilder.email(email);
        }
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            contactBuilder.phone(phone);
        }
        String mobilePhone = new LightningFormattedElement(driver, "Mobile Phone").getText();
        if (mobilePhone != "") {
            contactBuilder.mobilePhone(mobilePhone);
        }
        String reportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (reportsTo != "") {
            contactBuilder.reportsTo(reportsTo);
        }
        String department = new LightningFormattedElement(driver, "Department").getText();
        if (department != "") {
            contactBuilder.department(department);
        }
        String fax = new LightningFormattedElement(driver, "Fax").getText();
        if (fax != "") {
            contactBuilder.fax(fax);
        }
        String address = new LightningFormattedElement(driver, "Address").getText();
        if (address != "") {
            contactBuilder.mailingAddress(address);
        }
        String street = new LightningFormattedElement(driver, "Street").getText();
        if (street != "") {
            contactBuilder.street(street);
        }
        String province = new LightningFormattedElement(driver, "Province").getText();
        if (province != "") {
            contactBuilder.province(province);
        }
        String postalCode = new LightningFormattedElement(driver, "Postal Code").getText();
        if (postalCode != "") {
            contactBuilder.postalCode(postalCode);
        }
        String salutation = new LightningFormattedElement(driver, "Salutation").getText();
        if (salutation != "") {
            contactBuilder.salutation(Salutation.fromString(salutation));
        }
        return new Contact.ContactBuilder(
                lastName, accountName)
                .salutation(Salutation.fromString(salutation))
                .middleName(middleName)
                .suffix(suffix)
                .title(title)
                .email(email)
                .phone(phone)
                .mobilePhone(mobilePhone)
                .reportsTo(reportsTo)
                .department(department)
                .fax(fax)
                .mailingAddress(address)
                .street(street)
                .province(province)
                .postalCode(postalCode).build();
    }
}

