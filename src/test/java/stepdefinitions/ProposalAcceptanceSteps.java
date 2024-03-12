package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.customerPages.CustomerListOfProposalsPage;
import pages.customerPages.CustomerMainPage;
import pages.customerPages.CustomerProposalPage;
import pages.customerPages.CustomerSignaturePage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DataHolder;
import utils.DriverHelper;

import java.util.Map;

public class ProposalAcceptanceSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginSteps login = new LoginSteps();
    CustomerMainPage mainPage = new CustomerMainPage(driver);
    CustomerListOfProposalsPage listOfProposals = new CustomerListOfProposalsPage(driver);
    CustomerProposalPage proposalPage = new CustomerProposalPage(driver);
    CustomerSignaturePage signaturePage = new CustomerSignaturePage(driver);
    @When("User logs in with {string} credentials")
    public void userLogsInWithCredentials(String credentials) {
        login.user_provides_login_and_password_to_the_login_page(credentials);

    }

    @Then("User should see the page title {string}")
    public void user_should_see_the_page_title(String expectedTitle) {
        mainPage.validatePageTitle(driver, expectedTitle);
    }

    @When("User clicks on the {string} menu in the top navigation menu")
    public void user_clicks_on_the_menu_in_the_top_navigation_menu(String tabMenu) {
        mainPage.clickTabFromNavigationMenu(tabMenu);

    }

    @Then("User should verify that the proposal it was created in TC5 is in the list with")
    public void user_should_verify_that_the_proposal_it_was_created_in_tc5_is_in_the_list_with(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        //data.get("proposalName")
        //listOfProposals.checkForProposal(DataHolder.getInstance().getProposalName());
        listOfProposals.validateNameAndTotalPriceProposal(data.get("proposalName"), data.get("totalPrice"));
        System.out.println(DataHolder.getInstance().getProposalID());
        System.out.println(DataHolder.getInstance().getProposalName());
    }

    @Then("User gets the {string} proposal ID from the Proposal# column and save it as proposal_id")
    public void user_gets_the_proposal_id_from_the_proposal_column_and_save_it_as_proposal_id(String proposalName) {
//unimplemented yet but working on it
        DataHolder.getInstance().setProposalID(listOfProposals.getProposalId());

    }

    @When("User clicks on the created proposal {string} from the table")
    public void user_clicks_on_the_created_proposal_from_the_table(String proposal) {
        listOfProposals.clickCreatedProposal();
    }

    @Then("User should verify that the proposal_id matches the value in the h4 tag on the new page")
    public void user_should_verify_that_the_proposal_id_matches_the_value_in_the_h4_tag_on_the_new_page() {
//unimplemented yet but working on it
        Assert.assertEquals(DataHolder.getInstance().getProposalID(),proposalPage.getProposalID());
    }

    @Then("User should verify that the page title is {string}")
    public void user_should_verify_that_the_page_title_is(String expectedTitle) {
        proposalPage.validatePageTitle(driver, expectedTitle);
    }

    @Then("User should verify that the first item in the table is {string} and that the second item in the table is {string}")
    public void user_should_verify_that_the_first_item_in_the_table_is_and_that_the_second_item_in_the_table_is(String product1, String product2) {
        proposalPage.validateproductList(product1, product2);
    }

    @Then("User should see an Accept button on the page")
    public void user_should_see_an_accept_button_on_the_page() {
        proposalPage.validateAcceptButton();
    }

    @When("User clicks the Accept button")
    public void user_clicks_the_accept_button() {
        proposalPage.clickAcceptButton();
    }

    @When("User  clicks the Sign button on the pop-up screen")
    public void user_clicks_the_sign_button_on_the_pop_up_screen() {
        signaturePage.clickSign();
    }

    @Then("User should verify that will get red signature error message  under signature box")
    public void user_should_verify_that_will_get_red_signature_error_message_under_signature_box(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        signaturePage.validateSignDocumentAlert(data.get("message"), data.get("color"));
    }

    @Then("User draws a signature in canvas")
    public void user_draws_a_signature_in_canvas() {
        signaturePage.canvasDraw(driver);
    }

    @When("User clicks sign button")
    public void user_clicks_sign_button() {
        signaturePage.clickSign();
    }

    @Then("User should verify that they get {string} status label with {string} background color next to proposal id.")
    public void user_should_verify_that_they_get_status_label_with_background_color_next_to_proposal_id(String expectedText, String expectedColor) {
        proposalPage.validateAcceptedTextAndColor(expectedText, expectedColor);


    }
}
