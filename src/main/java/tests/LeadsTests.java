package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadsPage;

enum Industry {
    AGRICULTURE("Agriculture"), APPAREL("Apparel"), BANKING("Banking"), BIOTECHNOLOGY("Biotechnology"),
    CHEMICALS("Chemicals"), COMMUNICATIONS("Communications"), CONSTRUCTION("Construction"), CONSULTING("Consulting"),
    EDUCATION("Education"), ELECTRONICS("Electronics"), ENERGY("Energy"), ENGINEERING("Engineering"), ENTERTAINMENT("Entertainment"),
    ENVIRONMENTAL("Environmental"), FINANCE("Finance"), GOVERNMENT("Government"), HEALTHCARE("Healthcare"),
    HOSPITALITY("Hospitality"), INSURANCE("Insurance"), MACHINERY("Machinery"), MANUFACTURING("Manufacturing"),
    MEDIA("Media"), OTHER("Other"), RECREATION("Recreation"), RETAIL("Retail"), SHIPPING("Shipping"), TECHNOLOGY("Technology"),
    TELECOMMUNICATIONS("Telecommunications"), TRANSPORTATION("Transportation"), UTILITIES("Utilities");
    private final String industry;

    Industry(final String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }
}

public class LeadsTests extends BaseTest {

    protected final static String COMPANY = "QA19";
    protected final static String NUMBER_OF_Employees = "5";
    protected final static String STREET = "Ykrainki";
    protected final static String STATE = "Minskiy";
    protected final static String POSTAL_CODE = "220656";


    private LeadsPage leadsPage;

    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
    }

    @Test
    public void createLeadTest() {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        Assert.assertTrue(leadsPage.isLeadsIconDisplayed(), "Leads page transition failed");
        leadsPage.clickNewButton();
        leadsPage.waitForPageLoadedNew();
        Assert.assertTrue(leadsPage.isNewLeadsIconDisplayed(), "New leads page transition failed");
        leadsPage.getLeadsStatus("Working");
        leadsPage.getLeadsSalutation("Ms.");
        leadsPage.setFirstName(FIRSTNAME);
        leadsPage.setMiddleName(MIDDLE_NAME);
        leadsPage.setLastName(LASTNAME);
        leadsPage.setSuffix(SUFFIX);
        leadsPage.setTitle(TITLE);
        leadsPage.setEmail(EMAIL);
        leadsPage.setPhone(PHONE);
        leadsPage.setMobilePhone(MOBILE_PHONE);
        leadsPage.setCompany(COMPANY);
        Industry industry = Industry.valueOf("BANKING");
        leadsPage.getLeadsIndustry(industry.getIndustry());
        leadsPage.setNumberOfEmployees(NUMBER_OF_Employees);
        leadsPage.getLeadSource("Partner");
        leadsPage.getLeadAddress("Minsk");
        leadsPage.setStreet(STREET);
        leadsPage.setState(STATE);
        leadsPage.setPostalCode(POSTAL_CODE);
        leadsPage.clickSaveButton();
        leadsPage.waitForPageLoadedSave();
        Assert.assertTrue(leadsPage.isSaveLeadsIconDisplayed(), "New Lead not save");
    }
}