package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.customerPages.CustomerMainPage;
import pages.customerPages.InvoiceVerificationPage;
import utils.BrowserUtils;
import utils.DriverHelper;

import static org.junit.Assert.assertTrue;

public class InvoiceVerificationSteps {
    WebDriver driver = DriverHelper.getDriver();
   InvoiceVerificationPage invoicePage=new InvoiceVerificationPage(driver);
   CustomerMainPage customerMainPage=new CustomerMainPage(driver);

    @When("User clicks {string} menu")
    public void user_clicks_menu(String string) {
        invoicePage.clickInvoice();
    }
    @When("User verifies that the page title is {string}")
    public void user_verifies_that_the_page_title_is(String expectedTitle) {
        customerMainPage.validatePageTitle(driver,expectedTitle);

    }
    @When("User verifies that the invoice  {string} is received by the customer")
    public void user_verifies_that_the_invoice_is_received_by_the_customer(String expectedInvoiceNumber) {
        Assert.assertTrue(invoicePage.isInvoiceReceived(expectedInvoiceNumber));

    }
    @Then("User verifies that the status is labeled as {string} and background-color is {string}")
    public void user_verifies_that_the_status_is_labeled_as_and_background_color_is(String expectedStatus, String expectedColor) {
      invoicePage.getInvoiceStatus(expectedStatus,expectedColor);

    }




}
