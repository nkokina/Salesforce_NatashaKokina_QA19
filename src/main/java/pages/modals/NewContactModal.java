package pages.modals;

import elements.LightningBaseCombobox;
import elements.LightningCombobox;
import elements.LightningInput;
import elements.LightningTextaria;
import models.Contact;
import org.openqa.selenium.WebDriver;

public class NewContactModal extends BaseModal {

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillFord(Contact inputLead) {
        new LightningInput(driver, "First Name").setValue(inputLead.getFirstName());
        new LightningInput(driver, "Last Name").setValue(inputLead.getLastName());
        new LightningCombobox(driver, "Salutation").selectByVisibleText(inputLead.getSalutation().name);
        new LightningInput(driver, "Middle Name").setValue(inputLead.getMiddleName());
        new LightningInput(driver, "Suffix").setValue(inputLead.getSuffix());
        new LightningInput(driver, "Account Name").setValue(inputLead.getAccountName());
        new LightningInput(driver, "Title").setValue(inputLead.getTitle());
        new LightningInput(driver, "Email").setValue(inputLead.getEmail());
        new LightningInput(driver, "Phone").setValue(inputLead.getPhone());
        new LightningInput(driver, "Mobile").setValue(inputLead.getMobilePhone());
        new LightningBaseCombobox(driver, "Reports To").selectByVisibleText(inputLead.getReportsTo());
        new LightningInput(driver, "Department").setValue(inputLead.getDepartment());
        new LightningInput(driver, "Fax").setValue(inputLead.getFax());
        new LightningBaseCombobox(driver, "Search Address").selectByVisibleText(inputLead.getMailingAddress());
        new LightningTextaria(driver, "Mailing Street").setValue(inputLead.getStreet());
        new LightningInput(driver, "Mailing State/Province").setValue(inputLead.getProvince());
        new LightningInput(driver, "Mailing Zip/Postal Code").setValue(inputLead.getPostalCode());
    }
}
