package stepdefinitions.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.employeePage.InvoicesEmployeePage;
import utils.DriverHelper;

public class EmployeeInvoicesPageSteps {
    WebDriver driver = DriverHelper.getDriver();
    InvoicesEmployeePage invoicesEmployeePage = new InvoicesEmployeePage(driver);


    @When("User searches for the invoice ID {string} created in TC8 in invoices page and click")
    public void user_searches_for_the_invoice_id_created_in_tc8_in_invoices_page_and_click(String invoiceNumber) {
        invoicesEmployeePage.searchAndClickInvoiceFromList(invoiceNumber);
    }

    @Then("Verify that there is no {string} button next to the dropdown menu")
    public void verify_that_there_is_no_button_next_to_the_dropdown_menu(String paymentButton) {
        invoicesEmployeePage.verifyPaymentButtonisNotVisible(paymentButton);
    }
}
