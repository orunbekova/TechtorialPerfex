package pages.managerPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedInvoicePage {
    public SelectedInvoicePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='mleft10 pull-right btn btn-success']")
    WebElement paymentButton;
    @FindBy(xpath="//li[@class='icon header-user-profile']")
    WebElement accountIcon;
    @FindBy(tagName = "textarea")
    WebElement textSection;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;
    public void validatePaymentButton(String expectedColor){
        Assert.assertTrue(paymentButton.isDisplayed());
        Assert.assertEquals((paymentButton.getCssValue("background-color")),expectedColor);
    }
    public void clickPaymentButton(){
        paymentButton.click();
    }
    public void validateAccountIcon(){
        Assert.assertTrue(accountIcon.isDisplayed());
    }
    public void hoverOverAccountIconAndValidatesName(WebDriver driver, String expectedName){
        Actions actions=new Actions(driver);
        actions.moveToElement(accountIcon).perform();
        Assert.assertEquals(accountIcon.getAttribute("data-original-title"),expectedName);
    }
    public void leaveNote(String text) throws InterruptedException {
        String name = accountIcon.getAttribute("data-original-title");
        Thread.sleep(2000);
        textSection.sendKeys(name + " " + text);
    }
    public void clickGreenSaveButton(String expectedColor){
        Assert.assertEquals(saveButton.getCssValue("background-color"),expectedColor);
        saveButton.click();
    }

}
