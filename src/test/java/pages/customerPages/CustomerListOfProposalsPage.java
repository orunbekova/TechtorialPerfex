package pages.customerPages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CustomerListOfProposalsPage {
    public CustomerListOfProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "td-proposal-url-subject")
    List<WebElement> customerListOfProposals;
    @FindBy(xpath="//tbody/tr/td[1]/a")
    List<WebElement> listOfProposalsID;
    @FindBy(xpath = "//tbody/tr/td")
    List<WebElement> listOfAllElementsProposals;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a")
    WebElement proposal_ID;
    @FindBy(xpath="//input[@type='search']")
    WebElement searchButton;


    public void validateNameAndTotalPriceProposal(String expectedProposalName, String expectedTotalProposal) {
        List<String> expectedValues = Arrays.asList("", expectedProposalName, expectedTotalProposal, "", "", "");
        for (int i=0;i<customerListOfProposals.size();i++) {
            if (BrowserUtils.getText(customerListOfProposals.get(i)).equals(expectedProposalName)) {
                Assert.assertEquals(BrowserUtils.getText(listOfAllElementsProposals.get(2*(3*i+1))), expectedValues.get(2));
                break;
            }
        }
    }
    public String getProposalId (String proposalName) {
        for(int i=0;i<customerListOfProposals.size();i++){
            if(BrowserUtils.getText(customerListOfProposals.get(i)).equals(proposalName)){
                return BrowserUtils.getText(listOfProposalsID.get(i));
            }
        }
        return null;
    }


    public boolean checkForProposal (String proposalName){
        for (WebElement each : customerListOfProposals) {
            if (BrowserUtils.getText(each).equals(proposalName)) {
                return true;
            }
        }
        return false;
    }

    public void clickCreatedProposal (String createdProposal)  {
        searchButton.sendKeys(createdProposal);
//        for (WebElement each : customerListOfProposals) {
//            if (BrowserUtils.getText(each).equals(createdProposal)) {
//                each.click();
//                //Thread.sleep(2000);
//                break;
//            }
//        }
        customerListOfProposals.get(0).click();
    }

    //public static String proposal_id = BrowserUtils.getText(proposal_ID);
}
