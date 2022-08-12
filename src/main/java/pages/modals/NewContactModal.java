package pages.modals;

import elements.*;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewContactModal extends BaseModal {

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillingOutTheForm(Contact inputContact) {
        log.info(String.format("Creating new Contact with Lname=%s and Aname=%s", inputContact.getLastName(), inputContact.getAccountName()));
        new LightningInput(driver, "First Name").setValue(inputContact.getFirstName());
        new LightningInput(driver, "Last Name").setValue(inputContact.getLastName());
        new LightningCombobox(driver, "Salutation").selectByVisibleText(inputContact.getSalutation().name);
        new LightningInput(driver, "Middle Name").setValue(inputContact.getMiddleName());
        new LightningInput(driver, "Suffix").setValue(inputContact.getSuffix());
        new LightningContactBaseCombobox(driver, "Search Accounts...").selectByVisibleText(inputContact.getAccountName());
        new LightningInput(driver, "Title").setValue(inputContact.getTitle());
        new LightningInput(driver, "Email").setValue(inputContact.getEmail());
        new LightningInput(driver, "Phone").setValue(inputContact.getPhone());
        new LightningInput(driver, "Mobile").setValue(inputContact.getMobilePhone());
        new LightningContactBaseCombobox(driver, "Search Contacts...").selectByVisibleText(inputContact.getReportsTo());
        new LightningInput(driver, "Department").setValue(inputContact.getDepartment());
        new LightningInput(driver, "Fax").setValue(inputContact.getFax());
        new LightningBaseCombobox(driver, "Search Address").selectByVisibleText(inputContact.getMailingAddress());
        new LightningTextaria(driver, "Mailing Street").setValue(inputContact.getStreet());
        new LightningInput(driver, "Mailing State/Province").setValue(inputContact.getProvince());
        new LightningInput(driver, "Mailing Zip/Postal Code").setValue(inputContact.getPostalCode());
    }
}
