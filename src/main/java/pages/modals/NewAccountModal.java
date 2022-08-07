package pages.modals;

import elements.LightningBaseCombobox;
import elements.LightningCombobox;
import elements.LightningInput;
import elements.LightningTextaria;
import models.Account;
import org.openqa.selenium.WebDriver;


public class NewAccountModal extends BaseModal {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void fillFord(Account inputAccount) {
        new LightningInput(driver, "Account Name").setValue(inputAccount.getAccountName());
        new LightningInput(driver, "Website").setValue(inputAccount.getWebSite());
        new LightningTextaria(driver, "Description").setValue(inputAccount.getDescription());
        new LightningBaseCombobox(driver, "Parent Account").selectByVisibleText(inputAccount.getParentAccount());
        new LightningInput(driver, "Phone").setValue(inputAccount.getPhone());
        new LightningInput(driver, "Employees").setValue(inputAccount.getEmployees());
        new LightningInput(driver, "Billing Address").setValue(inputAccount.getBillingAddress());
        new LightningInput(driver, "Shipping Address").setValue(inputAccount.getShippingAddress());
        new LightningTextaria(driver, "Billing Street").setValue(inputAccount.getBillingStreet());
        new LightningTextaria(driver, "Shipping Street").setValue(inputAccount.getShippingStreet());
        new LightningInput(driver, "Billing State/Province").setValue(inputAccount.getBillingProvince());
        new LightningInput(driver, "Shipping State/Province").setValue(inputAccount.getShippingProvince());
        new LightningInput(driver, "Billing Zip/Postal Code").setValue(inputAccount.getBillingPostalCode());
        new LightningInput(driver, "Shipping Zip/Postal Code").setValue(inputAccount.getShippingPostalCode());
        new LightningCombobox(driver, "Industry").selectByVisibleText(inputAccount.getIndustry().getName());
        new LightningCombobox(driver, "Type").selectByVisibleText(inputAccount.getType().getName());

    }
}
