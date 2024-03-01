package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProposalsPage {
    public ProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='_buttons']//a[contains(@href,'proposals/proposal')]")
    WebElement newProposalButton;

    public void newProposalsButtonVisible() {
        Assert.assertTrue(newProposalButton.isDisplayed());
    }

    public void validateNewProposalButtonBackgroundColor(String color) {
        Assert.assertEquals(color, newProposalButton.getCssValue("background-color"));
    }
}