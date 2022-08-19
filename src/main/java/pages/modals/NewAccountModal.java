package pages.modals;

import elements.account.*;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAccountModal extends BaseModal {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void fillingOutTheForm(Account inputAccount) {
        log.info(String.format("Creating new Account with Aname=%s", inputAccount.getAccountName()));
        new LightningInputAccountName(driver, "Account Name").seyValue(inputAccount.getAccountName());
        new LightningBaseComboboxAccount(driver, "Search Accounts...").selectByVisibleText(inputAccount.getParentAccount());
        new LightningInputAccount(driver, "Website").seyValue(inputAccount.getWebSite());
        new LightningTextariaAccount(driver, "Description").setValue(inputAccount.getDescription());
        new LightningInputAccount(driver, "Phone").seyValue(inputAccount.getPhone());
        new LightningInputAccount(driver, "Employees").seyValue(inputAccount.getEmployees());
        new LightningInputAccountAddress(driver, "Billing Address").seyValue(inputAccount.getBillingAddress());
        new LightningInputAccountAddress(driver, "Shipping Address").seyValue(inputAccount.getShippingAddress());
        new LightningTextariaAccount(driver, "Billing Street").setValue(inputAccount.getBillingStreet());
        new LightningTextariaAccount(driver, "Shipping Street").setValue(inputAccount.getShippingStreet());
        new LightningInputAccount(driver, "Billing State/Province").seyValue(inputAccount.getBillingProvince());
        new LightningInputAccount(driver, "Shipping State/Province").seyValue(inputAccount.getShippingProvince());
        new LightningInputAccount(driver, "Billing Zip/Postal Code").seyValue(inputAccount.getBillingPostalCode());
        new LightningInputAccount(driver, "Shipping Zip/Postal Code").seyValue(inputAccount.getShippingPostalCode());
        if (inputAccount.getIndustry() != null) {
            new LightningComboboxAccount(driver, "Industry").selectByVisibleText(inputAccount.getIndustry().name);
        }
        if (inputAccount.getType() != null) {
            new LightningComboboxAccount(driver, "Type").selectByVisibleText(inputAccount.getType().name);
        }
    }
}
