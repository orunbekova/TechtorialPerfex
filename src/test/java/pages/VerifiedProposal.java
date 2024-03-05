package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VerifiedProposal {

    public VerifiedProposal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select")
    WebElement dropDownMenu;

    @FindBy(xpath = "//td//span[contains(text(),'Accepted')]")
    WebElement accepted;


    public void selectFromDropDown(String allOption) {
        Select menu = new Select(dropDownMenu);
        menu.selectByVisibleText(allOption);
    }

    public void validateAcceptedStatus() {
        Assert.assertTrue(accepted.isDisplayed());
    }
}
