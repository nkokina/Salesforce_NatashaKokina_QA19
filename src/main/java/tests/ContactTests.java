package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactPage;


public class ContactTests extends BaseTest {

    protected final static String ACCOUNT_NAME = "nKokina";
    private ContactPage contactPage;

    @BeforeClass
    public void initialise() {
        contactPage = new ContactPage(driver);
    }


    @Test
    public void createContactTest() {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForUserIconDisplayed();
        homePage.openContactsTab();
        contactPage.waitForPageLoaded();
        Assert.assertTrue(contactPage.isContactsIconDisplayed(), "Contacts page transition failed");
        contactPage.clickNewButton();
        contactPage.waitForPageLoadedNew();
        Assert.assertTrue(contactPage.isNewContactsIconDisplayed(), "New leads page transition failed");
        contactPage.getLeadsSalutation("Ms.");
        contactPage.setFirstName(FIRSTNAME);
        contactPage.setMiddleName(MIDDLE_NAME);
        contactPage.setLastName(LASTNAME);
        contactPage.setSuffix(SUFFIX);
        contactPage.clickAccountName(ACCOUNT_NAME);
        contactPage.waitForPageLoadedNewAccount();
        contactPage.setAccountName(ACCOUNT_NAME);
        contactPage.clickSaveAccountButton();
        contactPage.waitForPageLoadedNew();
        contactPage.setTitle(TITLE);
        contactPage.setEmail(EMAIL);
        contactPage.setPhone(PHONE);
        contactPage.setMobilePhone(MOBILE_PHONE);
        contactPage.clickSaveButton();
        contactPage.waitForPageLoadedSaveAccount();
        Assert.assertTrue(contactPage.isSaveNewContactsIconDisplayed(), "Save new leads page transition failed");

    }
}
