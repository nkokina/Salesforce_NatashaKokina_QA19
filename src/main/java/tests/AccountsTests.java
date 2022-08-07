package tests;

import enums.Industry;
import enums.Type;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.modals.NewAccountModal;


public class AccountsTests extends BaseTest {

    private AccountsPage accountsPage;
    private AccountDetailsPage accountDetailsPage;
    private NewAccountModal newAccountModal;

    @BeforeClass
    public void initialise() {
        accountsPage = new AccountsPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    @Test(dataProvider = "createAccountTestData")
    public void createAccountTest(String accountName, Type type, String webSite, String description, String parentAccount,
                                  String phone, Industry industry, String employees, String shippingAddress,
                                  String billingAddress, String billingStreet, String shippingStreet, String billingProvince,
                                  String shippingProvince, String shippingPostalCode, String billingPostalCode) {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        accountsPage.waitForPageLoaded();
        accountsPage.openNewButton();
        accountsPage.waitForPageLoadedNew();
        Assert.assertTrue(accountsPage.isLeadsIconDisplayed(), "Leads page transition failed");

        Account testLead = new Account.AccountBuilder(accountName)
                .type(type)
                .webSite(webSite)
                .description(description)
                .parentAccount(parentAccount)
                .phone(phone)
                .industry(industry)
                .employees(employees)
                .shippingAddress(shippingAddress)
                .billingAddress(billingAddress)
                .billingStreet(billingStreet)
                .shippingStreet(shippingStreet)
                .billingProvince(billingProvince)
                .shippingProvince(shippingProvince)
                .shippingPostalCode(shippingPostalCode)
                .billingPostalCode(billingPostalCode)
                .build();

        newAccountModal.fillFord(testLead);
        newAccountModal.clickSaveButton();
        accountsPage.openDetails();
        Assert.assertTrue(accountsPage.isConfimationPopupPresent());
        Assert.assertEquals(accountDetailsPage.getAccountInfo(), testLead);

    }

    @DataProvider
    public Object[][] createAccountTestData() {
        return new Object[][]{
                {faker.name().username(), Type.CUSTOMER, faker.internet().url(), faker.name().nameWithMiddle(), faker.name().name(),
                        faker.phoneNumber().phoneNumber(), Industry.BIOTECHNOLOGY, faker.number().digit(),
                        faker.address().cityName(), faker.address().cityName(), faker.address().streetAddress(),
                        faker.address().streetName(), faker.address().state(), faker.address().state(), faker.address().zipCode(),
                        faker.address().zipCode()},
                {faker.name().username()},
                {},
        };
    }
}
