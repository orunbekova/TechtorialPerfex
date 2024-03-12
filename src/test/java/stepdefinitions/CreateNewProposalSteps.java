package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.NewProposalPage;
import pages.ProposalsPage;
import utils.DataHolder;
import utils.DriverHelper;

import java.util.Map;

public class CreateNewProposalSteps {
    WebDriver driver = DriverHelper.getDriver();
    ProposalsPage proposalsPage= new ProposalsPage(driver);
    NewProposalPage newProposal = new NewProposalPage(driver);

    @Then("User creates new proposal with following data")
    public void user_creates_new_proposal_with_following_data(DataTable dataTable) throws InterruptedException {
        Map<String,String> data = dataTable.asMap();
        proposalsPage.clickNewProposalsButton();
        newProposal.addSubject(data.get("Subject"));
        newProposal.setRelatedSelect(data.get("Related"));
        newProposal.selectCustomerAndProject(data.get("Customer"),data.get("Project"));
        newProposal.selectItems(driver,data.get("ItemSelect1"),data.get("ItemSelect2"),data.get("Quantity"));
        newProposal.validateTotal(driver,data.get("Total"));
        newProposal.clickSend();



    }
    @Then("Find created Proposal and verify that its status is {string}")
    public void find_created_proposal_and_verify_that_its_status_is(String status) {
        proposalsPage.verifyCreatedProposal(status);
        proposalsPage.recordProposalIDAndProposalName();
        System.out.println(DataHolder.getInstance().getProposalName());
        System.out.println(DataHolder.getInstance().getProposalID());

    }

}
