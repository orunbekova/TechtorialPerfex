package pages.managerPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SelectedInvoicePage {
    public SelectedInvoicePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='mleft10 pull-right btn btn-success']")
    WebElement paymentButton;
    @FindBy(xpath = "//a[contains(text(), 'payment')]")
    WebElement paymentButtonPaymentPage;
    @FindBy(xpath="//li[@class='icon header-user-profile']")
    WebElement accountIcon;
    @FindBy(tagName = "textarea")
    WebElement textSection;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='col-md-3']//span[contains(text(), 'Paid')]")
    WebElement paidlabel;
    @FindBy(xpath = "//span[@class='badge']")
    WebElement badgeNo;
    @FindBy(xpath = "//a[contains(text(), 'Payments')]")
    WebElement paymentOntheRight;
    @FindBy(xpath = "//tr[@class='payment']")
    List<WebElement> paymentRow;
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

    public void validatePaymentButtonDisabled(){
        Assert.assertTrue(paymentButtonPaymentPage.isEnabled());

    }

    public void validatePaidLabel(){
      Assert.assertTrue(paidlabel.isDisplayed());
    }

    public void validateBadge(String badgeNumber){
        Assert.assertEquals(BrowserUtils.getText(badgeNo),badgeNumber );
    }
    public void clickPaymentRightSide()
    {
        paymentOntheRight.click();
    }
    public void validatePaymentMode(String paymentmode, String amount){
        for(int i=0; i<paymentRow.size();i++){
            Assert.assertEquals(BrowserUtils.getText(paymentRow.get(1)), paymentmode);
            Assert.assertEquals(BrowserUtils.getText(paymentRow.get(3)),amount);
        }
    }

}

