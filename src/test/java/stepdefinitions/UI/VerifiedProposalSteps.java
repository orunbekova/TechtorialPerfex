package stepdefinitions.UI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.VerifiedProposal;
import utils.DriverHelper;

public class VerifiedProposalSteps {

    WebDriver driver = DriverHelper.getDriver();

    VerifiedProposal verifiedProposal = new VerifiedProposal(driver);



    @Given("User set Table length {string} from drop down menu")
    public void user_set_table_length_from_drop_down_menu(String allOption) {
        verifiedProposal.selectFromDropDown(allOption);
    }

    @Then("User validates {string} in Proposal status")
    public void user_validates_in_proposal_status(String status) {
        verifiedProposal.validateAcceptedStatus();
    }



}
