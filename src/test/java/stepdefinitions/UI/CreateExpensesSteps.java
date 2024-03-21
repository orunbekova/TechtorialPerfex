package stepdefinitions.UI;

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
    public void user_creates_a_new_record_with_the_following_details(DataTable dataTable) throws InterruptedException {
        Map<String, String> data = dataTable.asMap();
        expensesPage.recordExpense(driver,data.get("Expense Name"),
                data.get("Note"),data.get("Expense Category"),
                data.get("Amount"),data.get("Customer"),data.get("Project"),data.get("Payment Mode"));

    }

    @When("User scrolls down and select the Save button")
    public void user_scrolls_down_and_select_the_save_button() {
        expensesPage.save();

    }

    @Then("User should see the expense recorded and listed in the Expense module")
    public void user_should_see_the_expense_recorded_and_listed_in_the_expense_module() {

    }

    @Then("User should find the created expense with the note {string}")
    public void user_should_find_the_created_expense_with_the_note(String expectedNote) {
        expensesPage.validateReceiptNote(expectedNote);

    }

    @Then("User should verify that the Created by record has the same name as the user's First and Last name displayed on the account icon on the top menu when hovered over")
    public void user_should_verify_that_the_created_by_record_has_the_same_name_as_the_user_s_first_and_last_name_displayed_on_the_account_icon_on_the_top_menu_when_hovered_over() {

    }

    @When("hover over record category column")
    public void hover_over_record_category_column() throws InterruptedException {
        expensesPage.hoverOverCategoryItem();
    }
    @Then("verify is shows {string}")
    public void verify_is_shows(String rowOption) {
       expensesPage.verifyRowOptions(rowOption);
    }
    @When("selecet View option")
    public void selecet_view_option() {
        expensesPage.clickViewOption();
    }
    @Then("verify that new panel show up expenses detail")
    public void verify_that_new_panel_show_up_expenses_detail() {
       expensesPage.verifyNewPanelIsDisplayed();
    }
    @Then("verify new panel hide when you click >> icon")
    public void verify_new_panel_hide_when_you_click_icon() {
        expensesPage.verifyAfterToggleNewPanelHide();
    }
    @Then("verify it shows up back when you clcik yable togle button")
    public void verify_it_shows_up_back_when_you_clcik_yable_togle_button() {
        expensesPage.verifyLefttoggleOpenNewPanel();
    }
}
