package pages;

import elements.LightningFormattedElement;
import enums.Salutation;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactDetailsPage extends BasePage {
    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public Contact getContactInfo() {
        log.info("Retrieving existing values from a partition Details");
        String lastName = new LightningFormattedElement(driver, "Name").getText();
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        Contact.ContactBuilder contactBuilder = Contact.builder().lastName(lastName).accountName(accountName);
        String firstName = new LightningFormattedElement(driver, "Name").getText();
        if (firstName != "") {
            contactBuilder.firstName(firstName);
        }
        String middleName = new LightningFormattedElement(driver, "Name").getText();
        if (middleName != "") {
            contactBuilder.middleName(middleName);
        }
        String suffix = new LightningFormattedElement(driver, "Name").getText();
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
        String mobilePhone = new LightningFormattedElement(driver, "Mobile").getText();
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
        String address = new LightningFormattedElement(driver, "Mailing Address").getText();
        if (address != "") {
            contactBuilder.mailingAddress(address);
        }
        String street = new LightningFormattedElement(driver, "Mailing Address").getText();
        if (street != "") {
            contactBuilder.street(street);
        }
        String province = new LightningFormattedElement(driver, "Mailing Address").getText();
        if (province != "") {
            contactBuilder.province(province);
        }
        String postalCode = new LightningFormattedElement(driver, "Mailing Address").getText();
        if (postalCode != "") {
            contactBuilder.postalCode(postalCode);
        }
        String salutation = new LightningFormattedElement(driver, "Name").getText();
        if (salutation != "") {
            contactBuilder.salutation(Salutation.fromString(salutation));
        }
        return Contact.builder().build();
    }
}

