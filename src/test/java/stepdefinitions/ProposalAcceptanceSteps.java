package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProposalAcceptanceSteps {
    WebDriver driver = DriverHelper.getDriver();

    @Then("User should see the page title {string}")
    public void user_should_see_the_page_title(String string) {

    }
    @When("User clicks on the {string} menu in the top navigation menu")
    public void user_clicks_on_the_menu_in_the_top_navigation_menu(String string) {

    }
    @Then("User should verify that the proposal it was created in TC5 is in the list with")
    public void user_should_verify_that_the_proposal_it_was_created_in_tc5_is_in_the_list_with(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("User gets the created proposal ID from the Proposal# column and save it as proposal_id")
    public void user_gets_the_created_proposal_id_from_the_proposal_column_and_save_it_as_proposal_id() {

    }
    @When("User clicks on the created proposal {string} from the table")
    public void user_clicks_on_the_created_proposal_from_the_table(String string) {

    }
    @Then("User should verify that the proposal_id matches the value in the h4 tag on the new page")
    public void user_should_verify_that_the_proposal_id_matches_the_value_in_the_h4_tag_on_the_new_page() {

    }
    @Then("User should verify that the page title is {string}")
    public void user_should_verify_that_the_page_title_is(String string) {

    }
    @Then("User should verify that the first item in the table is {string} and that the second item in the table is {string}")
    public void user_should_verify_that_the_first_item_in_the_table_is_and_that_the_second_item_in_the_table_is(String string, String string2) {

    }
    @Then("User should see an Accept button on the page")
    public void user_should_see_an_accept_button_on_the_page() {

    }
    @When("User clicks the Accept button")
    public void user_clicks_the_accept_button() {

    }
    @When("User  clicks the Sign button on the pop-up screen")
    public void user_clicks_the_sign_button_on_the_pop_up_screen() {

    }
    @Then("User should verify that will get red signature error message  under signature box")
    public void user_should_verify_that_will_get_red_signature_error_message_under_signature_box(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("User draws a signature in canvas")
    public void user_draws_a_signature_in_canvas() {

    }
    @When("User clicks sign button")
    public void user_clicks_sign_button() {

    }
    @Then("User should verify that they get {string} status label with {string} background color next to proposal id.")
    public void user_should_verify_that_they_get_status_label_with_background_color_next_to_proposal_id(String string, String string2) {

    }
}
