package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.NewProposalPage;
import pages.ProposalsPage;
import utils.BrowserUtils;
import utils.DriverHelper;

public class NewProposalSteps {
    WebDriver driver= DriverHelper.getDriver();
    NewProposalPage newProposalPage = new NewProposalPage(driver);
    ProposalsPage proposalsPage = new ProposalsPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @When("User enters {string} in subject line")
    public void user_enters_in_subject_line(String subject) {
        newProposalPage.setSubject(subject);
    }
    @When("User choose {string} and search&choose {string} & {string} from customer,{string} from Project")
    public void user_choose_and_search_choose_from_customer_from_project(String related, String search, String client, String project) throws InterruptedException {
       newProposalPage.createNewProposal(related, search, client, project);
    }


    @When("User choose {string} from drop addItem with quantity {string}dropdown and clicks add button")
    public void user_choose_from_drop_add_item_with_quantity_dropdown_and_clicks_add_button(String itemName, String quantity) throws InterruptedException {

        newProposalPage.addItem(itemName,quantity);
    }
    @When("User adds {string} from drop addItem with quantity {string}dropdown and clicks add button")
    public void user_adds_from_drop_add_item_with_quantity_dropdown_and_clicks_add_button(String itemName, String quantity) throws InterruptedException {
        newProposalPage.addItem(itemName,quantity);
        Thread.sleep(2000);
    }
    @Then("User validate that proposals total price is {string}")
    public void user_validate_that_proposals_total_price_is(String total) throws InterruptedException {
        newProposalPage.validateTotalPrice(total);
        Thread.sleep(2000);
    }
    @When("User clicks save&send button")
    public void user_clicks_save_send_button() throws InterruptedException {
        newProposalPage.clickSaveSend();
    }
    @Then("User validates the new proposal is added with {string} and deletes the Proposal")
    public void user_validates_the_new_proposal_is_added_with_and_deletes_the_proposal(String status) throws InterruptedException {
       proposalsPage.validateCreatedProposalStatus(status);
       proposalsPage.deleteProposal(this.driver);
    }
    @When("User Logs Out as employee")
    public void user_logs_out_as_employee() throws InterruptedException {


       dashboardPage.logout(this.driver);
    }

}
