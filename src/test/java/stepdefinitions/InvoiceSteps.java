package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.InvoicePage;
import pages.ProposalsPage;
import utils.DriverHelper;

public class InvoiceSteps {
    WebDriver driver= DriverHelper.getDriver();
    ProposalsPage proposalsPage = new ProposalsPage(driver);
    InvoicePage invoicePage = new InvoicePage(driver);

    @When("User search {string} in proposals")
    public void user_search_in_proposals(String subject) {
       proposalsPage.searchProposal(subject);
    }
    @Then("User validates {string} {string} {string}")
    public void user_validates(String subject, String projectName, String status) throws InterruptedException {
        proposalsPage.validateProposalCredentials(subject, projectName, status);
    }
    @When("User Click associated proposal id from proposal column")
    public void user_click_associated_proposal_id_from_proposal_column() throws InterruptedException {
        proposalsPage.clickProposalId(this.driver);
    }
    @And("User clicks comments enters {string} & clicks Add comment")
    public void user_clicks_comments_enters_clicks_add_comment(String comment) throws InterruptedException {
        proposalsPage.addCommentToProposal(comment);
    }
    @Then("User verifies that next to Comments tab there is {string} badge for total comment")
    public void user_verifies_that_next_to_comments_tab_there_is_badge_for_total_comment(String number) {
        proposalsPage.verifyCommentsNumber(number);
    }
    @When("User Click Convert button and Select Invoice button from drop down menu.")
    public void user_click_convert_button_and_select_invoice_button_from_drop_down_menu() {
       proposalsPage.convertInvoice();
    }
    @Then("User Verifies that Customer is {string} as default and Scrools down page and clicks Save button")
    public void user_verifies_that_customer_is_as_default_and_scrools_down_page_and_clicks_save_button(String client) throws InterruptedException {
        Thread.sleep(1000);
        invoicePage.verifyCustomerDefaultOption(client);
        invoicePage.saveInvoice(this.driver);
    }
    @Then("User verifies that there is red {string} label next to record header")
    public void user_verifies_that_there_is_red_label_next_to_record_header(String status) {
        invoicePage.verifyInvoiceStatus(status);
    }
    @Then("User Verifies that record header that starts with INV- same number with Invoice Number section in the form")
    public void user_verifies_that_record_header_that_starts_with_inv_same_number_with_invoice_number_section_in_the_form() throws InterruptedException {
      invoicePage.verifyInvoiceNumber();
    }
    @And("User deletes invoice")
    public void user_deletes_invoice() throws InterruptedException {
invoicePage.deleteInvoice(this.driver);
    }
    @And("User deletes proposal")
    public void user_deletes_proposal() throws InterruptedException {
        proposalsPage.deleteProposal(this.driver);
    }





}
