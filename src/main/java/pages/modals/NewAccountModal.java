package pages.modals;

import elements.LightningBaseCombobox;
import elements.LightningCombobox;
import elements.LightningInput;
import elements.LightningTextaria;
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
        new LightningInput(driver, "Account Name").seyValueAccountName(inputAccount.getAccountName());
        new LightningBaseCombobox(driver, "Search Accounts...").selectByVisibleTextAccount(inputAccount.getParentAccount());
        new LightningInput(driver, "Website").seyValueAccount(inputAccount.getWebSite());
        new LightningTextaria(driver, "Description").setValueAccount(inputAccount.getDescription());
        new LightningInput(driver, "Phone").seyValueAccount(inputAccount.getPhone());
        new LightningInput(driver, "Employees").seyValueAccount(inputAccount.getEmployees());
        new LightningInput(driver, "Billing Address").seyValueAccountButton(inputAccount.getBillingAddress());
        new LightningInput(driver, "Shipping Address").seyValueAccountButton(inputAccount.getShippingAddress());
        new LightningTextaria(driver, "Billing Street").setValueAccount(inputAccount.getBillingStreet());
        new LightningTextaria(driver, "Shipping Street").setValueAccount(inputAccount.getShippingStreet());
        new LightningInput(driver, "Billing State/Province").seyValueAccount(inputAccount.getBillingProvince());
        new LightningInput(driver, "Shipping State/Province").seyValueAccount(inputAccount.getShippingProvince());
        new LightningInput(driver, "Billing Zip/Postal Code").seyValueAccount(inputAccount.getBillingPostalCode());
        new LightningInput(driver, "Shipping Zip/Postal Code").seyValueAccount(inputAccount.getShippingPostalCode());
        new LightningCombobox(driver, "Industry").selectByVisibleTextAccount(inputAccount.getIndustry().name);
        new LightningCombobox(driver, "Type").selectByVisibleTextAccount(inputAccount.getType().name);
    }
}
