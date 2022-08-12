package pages;

import elements.LightningFormattedElement;
import enums.Industry;
import enums.Type;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public Account getAccountInfo() {
        log.info("Retrieving existing values from a partition Details");
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        Account.AccountBuilder accountBuilder = Account.builder().accountName(accountName);
        String type = new LightningFormattedElement(driver, "Type").getText();
        if (type != "") {
            accountBuilder.type(Type.fromString(type));
        }
        String webSite = new LightningFormattedElement(driver, "Website").getText();
        if (webSite != "") {
            accountBuilder.webSite(webSite);
        }
        String description = new LightningFormattedElement(driver, "Description").getText();
        if (description != "") {
            accountBuilder.description(description);
        }
        String parentAccount = new LightningFormattedElement(driver, "ParentAccount").getText();
        if (parentAccount != "") {
            accountBuilder.parentAccount(parentAccount);
        }
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            accountBuilder.phone(phone);
        }
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        if (industry != "") {
            accountBuilder.industry(Industry.fromString(industry));
        }
        String employees = new LightningFormattedElement(driver, "Employees").getText();
        if (employees != "") {
            accountBuilder.employees(employees);
        }
        String billingAddress = new LightningFormattedElement(driver, "BillingAddress").getText();
        if (billingAddress != "") {
            accountBuilder.billingAddress(billingAddress);
        }
        String shippingAddress = new LightningFormattedElement(driver, "ShippingAddress").getText();
        if (shippingAddress != "") {
            accountBuilder.shippingAddress(shippingAddress);
        }
        String billingStreet = new LightningFormattedElement(driver, "BillingStreet").getText();
        if (billingStreet != "") {
            accountBuilder.billingStreet(billingStreet);
        }
        String shippingStreet = new LightningFormattedElement(driver, "ShippingStreet").getText();
        if (shippingStreet != "") {
            accountBuilder.shippingStreet(shippingStreet);
        }
        String billingProvince = new LightningFormattedElement(driver, "Billing Province").getText();
        if (billingProvince != "") {
            accountBuilder.billingProvince(billingProvince);
        }
        String shippingProvince = new LightningFormattedElement(driver, "Shipping Province").getText();
        if (shippingProvince != "") {
            accountBuilder.shippingProvince(shippingProvince);
        }
        String shippingPostalCode = new LightningFormattedElement(driver, "Shipping Postal Code").getText();
        if (shippingPostalCode != "") {
            accountBuilder.webSite(shippingPostalCode);
        }
        String billingPostalCode = new LightningFormattedElement(driver, "Billing Postal Code").getText();
        if (billingPostalCode != "") {
            accountBuilder.billingPostalCode(billingPostalCode);
        }
        return Account.builder().build();
    }
}

