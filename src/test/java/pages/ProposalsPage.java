package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
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
    @FindBy(xpath = "//span[@id='proposal-number']")
    WebElement newCreatedProposalNumber;
    @FindBy(xpath = "//tbody/tr/td")
    List<WebElement> allProposalsElements;
    @FindBy(xpath="//tr/td/a")
    List<WebElement> allClickableProposalsElements;
    @FindBy(xpath = "//div[@class='btn-group ']")
    WebElement selectMore;
    @FindBy(xpath = "//a[@class='text-danger delete-text _delete']")
    WebElement deleteProposal;

    public void newProposalsButtonVisible() {
        Assert.assertTrue(newProposalButton.isDisplayed());
    }

    public void validateNewProposalButtonBackgroundColor(String color) {
        Assert.assertEquals(color, newProposalButton.getCssValue("background-color"));
    }

    public void clickNewProposalsButton() {
        newProposalButton.click();
    }

    public void verifyCreatedProposal(String status) {
        String proposalNumber = BrowserUtils.getText(newCreatedProposalNumber);
        for (int i = 0; i < allProposalsElements.size(); i++) {
            if (BrowserUtils.getText(allProposalsElements.get(i)).equals(proposalNumber)) {
                Assert.assertEquals(status, BrowserUtils.getText(allProposalsElements.get(i + 4)));
                break;
            }
        }
    }

    public void recordProposalIDAndProposalName() {
        String proposalNumber = BrowserUtils.getText(newCreatedProposalNumber);
        for (int i = 0; i < allProposalsElements.size(); i++) {
            if (BrowserUtils.getText(allProposalsElements.get(i)).equals(proposalNumber)) {
                DataHolder.setProposalID(proposalNumber);
                DataHolder.setProposalName(BrowserUtils.getText(allProposalsElements.get(i + 1)));

            }
        }
    }

    public void clickAndDeleteProposalToBeDeleted(WebDriver driver) throws InterruptedException {

        for (int i = 0; i < allClickableProposalsElements.size(); i++) {
            if (BrowserUtils.getText(allClickableProposalsElements.get(i)).equals(DataHolder.getProposalID())) {
                allClickableProposalsElements.get(i).click();
                Thread.sleep(2000);
                break;
            }
        }
        selectMore.click();
        deleteProposal.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }
}