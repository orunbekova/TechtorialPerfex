package stepdefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.managerPages.InvoicesPage;
import pages.managerPages.ManagerMainPage;
import pages.managerPages.ManagerPaymentPage;
import pages.managerPages.SelectedInvoicePage;
import utils.DriverHelper;

public class CreatePaymentForInvoiceSteps {
    WebDriver driver = DriverHelper.getDriver();
    ManagerMainPage managerMainPage = new ManagerMainPage(driver);
    InvoicesPage invoicesPage = new InvoicesPage(driver);
    SelectedInvoicePage selectedInvoicePage = new SelectedInvoicePage(driver);

    ManagerPaymentPage managerPaymentPage = new ManagerPaymentPage(driver);


    @Then("User clicks on the {string} module from the left side navigation menu")
    public void user_clicks_on_the_module_from_the_left_side_navigation_menu(String option) {
        managerMainPage.clickSideMenuOption(option);
    }

    @Then("User clicks on the {string} module")
    public void user_clicks_on_the_module(String option) {
        managerMainPage.clickSalesSubMenu(option);

    }

    @Then("User searches for the invoice ID {string} created in TC8")
    public void user_searches_for_the_invoice_id_number_created_in_tc(String invoiceID) {
        // invoicesPage.searchInvoice(invoiceID);

    }

    @Then("User selects the found invoice ID {string} from the Invoice# column")
    public void userSelectsTheFoundInvoiceIDFromTheInvoiceColumn(String invoiceID) {
        invoicesPage.searchAndClickInvoiceFromList(invoiceID);
    }

    @Then("User verifies that there is a Payment button of color {string}")
    public void user_verifys_that_there_is_payment_button_of_color(String expectedColor) {
        selectedInvoicePage.validatePaymentButton(expectedColor);
    }

    @Then("User clicks the Payment button")
    public void user_clicks_the_payment_button() {
        selectedInvoicePage.clickPaymentButton();
    }

    @Then("User validates that there is an account icon on top of the page")
    public void user_validates_that_there_is_an_account_icon_on_top_of_the_page() {
        selectedInvoicePage.validateAccountIcon();
    }

    @When("User hovers over the account icon with a blank person image, it shows the name of the user {string}")
    public void user_hovers_over_the_account_icon_with_a_blank_person_image_it_shows_the_name_of_the_user_(String expectedName) {
        selectedInvoicePage.hoverOverAccountIconAndValidatesName(driver, expectedName);
    }

    @When("User adds the user's first and last name from the account icon and {string} to the payment's Leave a note section")
    public void user_adds_the_user_s_first_and_last_name_from_the_account_icon_to_the_payment_s_leave_a_note_section(String text) throws InterruptedException {
        selectedInvoicePage.leaveNote(text);
    }

    @And("User clicks the green {string} Save button")
    public void userClicksTheGreenSaveButton(String expectedColor) {
        selectedInvoicePage.clickGreenSaveButton(expectedColor);

    }


    @When("User searches for the invoice ID {string} created in TC8 payment page")
    public void user_searches_for_the_invoice_id_created_in_tc8_payment_page(String invoiceId) {
        // managerPaymentPage.searchInvoice(invoiceId);
    }

    @When("User selects the found invoice ID {string} from the Invoice# column in payment page")
    public void user_selects_the_found_invoice_id_from_the_invoice_column_in_payment_page(String invoiceId) {
        managerPaymentPage.searchAndClickInvoiceFromList(invoiceId);
    }

    @Then("User verifies that Payment button is disabled")
    public void user_verifies_that_payment_button_is_disabled() {
        selectedInvoicePage.validatePaymentButtonDisabled();
    }

    @Then("User verifies Paid label is displayed under Invoices tab in right panel")
    public void user_verifies_paid_label_is_displayed_under_invoices_tab_in_right_panel() {
        selectedInvoicePage.validatePaidLabel();
    }

    @Then("User verifies that a payment badge {string} added next to Payment tab")
    public void user_verifies_that_a_payment_badge_added_next_to_payment_tab(String badgeNu) {
        selectedInvoicePage.validateBadge(badgeNu);
    }

    @When("User clicks on the {string} on selected invoice")
    public void user_clicks_on_the_on_selected_invoice(String paymentMode) {
        selectedInvoicePage.clickPaymentRightSide();
    }

    @Then("verify payment mode is {string} and paid amount is {string}")
    public void verify_payment_mode_is_and_paid_amount_is(String paymentMode, String amount) {

    }


}
