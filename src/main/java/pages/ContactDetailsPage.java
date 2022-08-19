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
        Contact.ContactBuilder contactBuilder = Contact.builder();
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        String name = new LightningFormattedElement(driver, "Name").getText();

        String[] parsedName = name.split(" ");

        if (parsedName.length == 5) {
            contactBuilder.salutation(Salutation.fromString(parsedName[0]))
                    .firstName(parsedName[1])
                    .middleName(parsedName[2])
                    .lastName(parsedName[3])
                    .suffix(parsedName[4]);
        }
        contactBuilder.accountName(accountName);
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
            String department = new LightningFormattedElement(driver, "Department").getText();
        if (department != "") {
            contactBuilder.department(department);
        }
        String fax = new LightningFormattedElement(driver, "Fax").getText();
        if (fax != "") {
            contactBuilder.fax(fax);
        }
        String address = new LightningFormattedElement(driver, "Mailing Address").getText().replace('\n',' ');
        String[] parsedAddress = address.split(" ");
        contactBuilder.street(parsedAddress[0])
                .mailingAddress(parsedAddress[1])
                .province(parsedAddress[2])
                .postalCode(parsedAddress[3]);

        return contactBuilder.build();
    }
}

