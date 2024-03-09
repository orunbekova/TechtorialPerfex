package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.managerPages.ExpensesPage;
import utils.DriverHelper;

import java.util.Map;

public class CreateExpensesSteps {
    WebDriver driver = DriverHelper.getDriver();
    ExpensesPage expensesPage = new ExpensesPage(driver);

    @Then("User should see the page title as {string}")
    public void user_should_see_the_page_title_as(String expectedTitle) {
        expensesPage.validatePageTitle(driver, expectedTitle);
    }

    @When("User clicks on the + Record Expense button")
    public void user_clicks_on_the_record_expense_button() {
        expensesPage.clickRecordExpense();

    }

    @When("User creates a new record with the following details:")
    public void user_creates_a_new_record_with_the_following_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();

    }

    @When("User scrolls down and select the {string} button")
    public void user_scrolls_down_and_select_the_button(String string) {

    }

    @Then("User should see the expense recorded and listed in the Expense module")
    public void user_should_see_the_expense_recorded_and_listed_in_the_expense_module() {

    }

    @Then("User should find the created expense with the note {string}")
    public void user_should_find_the_created_expense_with_the_note(String string) {

    }

    @Then("User should verify that the Created by record has the same name as the user's First and Last name displayed on the account icon on the top menu when hovered over")
    public void user_should_verify_that_the_created_by_record_has_the_same_name_as_the_user_s_first_and_last_name_displayed_on_the_account_icon_on_the_top_menu_when_hovered_over() {

    }
}
