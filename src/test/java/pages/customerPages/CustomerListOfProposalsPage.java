package pages.customerPages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DataHolder;

import java.util.Arrays;
import java.util.List;

public class CustomerListOfProposalsPage {
    public CustomerListOfProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "td-proposal-url-subject")
    List<WebElement> customerListOfProposals;
    @FindBy(xpath = "//tbody/tr/td[1]/a")
    List<WebElement> listOfProposalsID;
    @FindBy(xpath = "//tbody/tr/td")
    List<WebElement> listOfAllElementsProposals;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a")
    WebElement proposal_ID;
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchButton;


    public void validateNameAndTotalPriceProposal(String expectedProposalName, String expectedTotalProposal) {
        List<String> expectedValues = Arrays.asList("", expectedProposalName, expectedTotalProposal, "", "", "");
//        for (int i=0;i<customerListOfProposals.size();i++) {
//            if (BrowserUtils.getText(customerListOfProposals.get(i)).equals(expectedProposalName)) {
//                Assert.assertEquals(expectedValues.get(2),BrowserUtils.getText(listOfAllElementsProposals.get(2*(3*i+1))));
//                break;
//            }
//        }
        for (int i = 0; i < listOfAllElementsProposals.size(); i++) {
            if (BrowserUtils.getText(listOfAllElementsProposals.get(i)).equals(DataHolder.getProposalID())) {
                Assert.assertEquals(expectedValues.get(1), BrowserUtils.getText(listOfAllElementsProposals.get(i + 1)));
                Assert.assertEquals(expectedValues.get(2), BrowserUtils.getText(listOfAllElementsProposals.get(i + 2)));
            }
        }
    }

    public String getProposalId() {
        for (int i = 0; i < listOfAllElementsProposals.size(); i++) {
            if (BrowserUtils.getText(listOfAllElementsProposals.get(i)).equals(DataHolder.getProposalID())) {
                return BrowserUtils.getText(listOfAllElementsProposals.get(i));
            }
        }
        return null;
    }


    public boolean checkForProposal(String proposalName) {
        for (WebElement each : customerListOfProposals) {
            if (BrowserUtils.getText(each).equals(proposalName)) {
                return true;
            }
        }
        return false;
    }

    public void clickCreatedProposal() {

        for (int i = 0; i < listOfAllElementsProposals.size(); i++) {
            if (BrowserUtils.getText(listOfAllElementsProposals.get(i)).equals(DataHolder.getProposalID())) {
                listOfAllElementsProposals.get(i).click();
            }
        }
    }


}
