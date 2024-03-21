package stepdefinitions.UI;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.ProposalsPage;
import utils.DriverHelper;

public class DeleteProposalSteps {
   WebDriver driver = DriverHelper.getDriver();
   ProposalsPage proposal = new ProposalsPage(driver);

    @And("User clicks and deletes the proposal created in TPX5")
    public void userClicksAndDeletesTheProposalCreatedInTPX() throws InterruptedException {
        proposal.clickAndDeleteProposalToBeDeleted(driver);
    }
}
