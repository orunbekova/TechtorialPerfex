package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DataHolder;

import java.util.List;

public class ProposalsPage {
    public ProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='_buttons']//a[contains(@href,'proposals/proposal')]")
    WebElement newProposalButton;
    @FindBy(xpath="//span[@id='proposal-number']")
    WebElement newCreatedProposalNumber;
    @FindBy(xpath="//tbody/tr/td")
    List<WebElement> allProposalsElements;

    public void newProposalsButtonVisible() {
        Assert.assertTrue(newProposalButton.isDisplayed());
    }

    public void validateNewProposalButtonBackgroundColor(String color) {
        Assert.assertEquals(color, newProposalButton.getCssValue("background-color"));
    }
    public void clickNewProposalsButton(){
        newProposalButton.click();
    }
    public void verifyCreatedProposal(String status){
        String proposalNumber= BrowserUtils.getText(newCreatedProposalNumber);
        for(int i=0;i<allProposalsElements.size();i++){
            if(BrowserUtils.getText(allProposalsElements.get(i)).equals(proposalNumber)){
                Assert.assertEquals(status,BrowserUtils.getText(allProposalsElements.get(i+4)));
                break;
            }
        }
    }
    public void recordProposalIDAndProposalName(){
        String proposalNumber= BrowserUtils.getText(newCreatedProposalNumber);
        for(int i=0;i<allProposalsElements.size();i++){
            if(BrowserUtils.getText(allProposalsElements.get(i)).equals(proposalNumber)){
                DataHolder.getInstance().setProposalID(proposalNumber);
                DataHolder.getInstance().setProposalName(BrowserUtils.getText(allProposalsElements.get(i+1)));

            }
        }

    }
}