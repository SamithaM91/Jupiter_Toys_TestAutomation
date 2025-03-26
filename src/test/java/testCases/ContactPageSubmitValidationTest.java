package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactPageSubmitValidationTest extends BaseClass {

    @Test(invocationCount = 5)
    public void TC002(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillMandatoryFields("Samitha", "samitha@example.com", "Hello Samitha!");
        contactPage.clickSubmit();
        Assert.assertFalse(contactPage.areErrorsDisplayed(), "Success Message should be displayed");


    }

}