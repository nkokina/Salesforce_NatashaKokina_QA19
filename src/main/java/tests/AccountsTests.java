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
    public void createAccountTest(Account testAccount) {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openAccountsTab();
        accountsPage.waitForPageLoaded();
        accountsPage.openNewButton();
        accountsPage.waitForPageLoadedNew();
        Assert.assertTrue(accountsPage.isLeadsIconDisplayed(), "Leads page transition failed");

        newAccountModal.fillingOutTheForm(testAccount);
        accountsPage.clickSave();
        accountsPage.openDetails();
        Assert.assertTrue(accountsPage.isConfimationPopupPresent("was created"));
        accountsPage.openDetails();
        Assert.assertEquals(accountDetailsPage.getAccountInfo(), testAccount);
    }

    @DataProvider
    public Object[][] createAccountTestData() {
        return new Object[][]{
                {Account.builder().accountName(faker.name().username()).type(Type.CUSTOMER).webSite(faker.internet().url())
                        .description(faker.name().nameWithMiddle())
                        .phone(faker.phoneNumber().phoneNumber()).industry(Industry.BIOTECHNOLOGY)
                        .employees(faker.number().digit()).shippingAddress("Minsk")
                        .billingAddress("Minsk").billingStreet("Ykrainki")
                        .shippingStreet("Ykrainki").billingProvince("Minskiy")
                        .shippingProvince("Minskiy").shippingPostalCode(faker.address().zipCode())
                        .billingPostalCode(faker.address().zipCode()).build()},
                {Account.builder().accountName(faker.name().username()).shippingAddress("Minsk")
                        .billingAddress("Minsk").billingStreet("Ykrainki")
                        .shippingStreet("Ykrainki").billingProvince("Minskiy")
                        .shippingProvince("Minskiy").shippingPostalCode(faker.address().zipCode())
                        .billingPostalCode(faker.address().zipCode()).build()},
        };
    }
}
