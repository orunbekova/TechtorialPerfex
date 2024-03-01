package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProposalsPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProposalsSteps {
    WebDriver driver= DriverHelper.getDriver();
    DashboardPage dashboardPage=new DashboardPage(driver);
    ProposalsPage proposalsPage=new ProposalsPage(driver);


    @When("User click Sales Module from left side navigation menu")
    public void user_click_sales_module_from_left_side_navigation_menu() {
        dashboardPage.salesClick();
    }
    @When("User Click Proposals module")
    public void user_click_proposals_module() {
        dashboardPage.proposalsClick();
    }
    @Then("User validates that there a button New Proposal is visible")
    public void user_validates_that_there_a_button_new_proposal_is_visible() {
        proposalsPage.newProposalsButtonVisible();
    }
    @Then("User validates that New Proposal button background-color is {string}")
    public void user_validates_that_new_proposal_button_background_color_is(String color) {

    }

}
