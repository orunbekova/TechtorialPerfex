package stepdefinitions.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.managerPages.PaidInvoicesPage;
import utils.DriverHelper;
public class PaidInvoicesSteps {
    WebDriver driver = DriverHelper.getDriver();
    PaidInvoicesPage paidInvoicesPage=new PaidInvoicesPage(driver);
    DashboardPage dashboardPage=new DashboardPage(driver);
    @When("User filters the invoices by Paid")
    public void user_filters_the_invoices_by() throws InterruptedException {
        paidInvoicesPage.clickFilterButton();
        paidInvoicesPage.clickPaidButton();
        Thread.sleep(1000);
        paidInvoicesPage.clickFilterButton();
    }
    @When("User verifies that the total {string} records match the count of displayed {string} in the bottom of the table")
    public void user_verifies_that_the_total_records_match_the_count_of_displayed_in_the_bottom_of_the_table(String paidRecord, String entitiesCount) {
       Assert.assertEquals(paidInvoicesPage.verifyPaidInvoiceCount(paidRecord),entitiesCount);

    }
    @When("User navigates to Dashboard  module")
    public void user_navigates_to_dashboard_module() {
      paidInvoicesPage.dashboardClick();
    }

    @Then("User verifies that {string} section shows same number of {string} record entities")
    public void user_verifies_that_section_shows_same_number_of_record_entities(String string, String string2) {

    }


}
