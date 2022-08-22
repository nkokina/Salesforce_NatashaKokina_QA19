package pages.modals;

import elements.LightningBaseCombobox;
import elements.LightningCombobox;
import elements.LightningInput;
import elements.LightningTextaria;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.WebDriver;


@Log4j2
public class NewLeadModal extends BaseModal {
    public NewLeadModal(WebDriver driver) {
        super(driver);
    }

    public void fillingOutTheForm(Lead inputLead) {
        log.info(String.format("Creating new Lead with Lname=%s and Company=%s", inputLead.getLastName(), inputLead.getCompany()));
        new LightningInput(driver, "Company").setValue(inputLead.getCompany());
        new LightningCombobox(driver, "Lead Status").selectByVisibleText(inputLead.getLeadStatus().name);
        if (inputLead.getSalutation()!=null) {
            new LightningCombobox(driver, "Salutation").selectByVisibleText(inputLead.getSalutation().name);
        }
        new LightningInput(driver, "First Name").setValue(inputLead.getFirstName());
        new LightningInput(driver, "Middle Name").setValue(inputLead.getMiddleName());
        new LightningInput(driver, "Last Name").setValue(inputLead.getLastName());
        new LightningInput(driver, "Suffix").setValue(inputLead.getSuffix());
        new LightningInput(driver, "Title").setValue(inputLead.getTitle());
        new LightningInput(driver, "Email").setValue(inputLead.getEmail());
        new LightningInput(driver, "Website").setValue(inputLead.getWebSite());
        new LightningInput(driver, "Phone").setValue(inputLead.getPhone());
        new LightningInput(driver, "Mobile").setValue(inputLead.getMobilePhone());
        if (inputLead.getIndustry()!=null) {
            new LightningCombobox(driver, "Industry").selectByVisibleText(inputLead.getIndustry().name);
        }
        new LightningInput(driver, "No. of Employees").setValue(inputLead.getNumberOfEmployees());
        if (inputLead.getLeadSource()!=null) {
            new LightningCombobox(driver, "Lead Source").selectByVisibleText(inputLead.getLeadSource().name);
        }
        new LightningBaseCombobox(driver, "Search Address").selectByVisibleText(inputLead.getAddress());
        new LightningTextaria(driver, "Street").setValue(inputLead.getStreet());
        new LightningInput(driver, "State/Province").setValue(inputLead.getProvince());
        new LightningInput(driver, "Zip/Postal Code").setValue(inputLead.getPostalCode());
    }
}
