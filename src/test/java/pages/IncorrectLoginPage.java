package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncorrectLoginPage {

    public IncorrectLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#email")
    WebElement email;
    @FindBy(css = "#password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Invalid email')] ")
    WebElement errorMessage;


    public void IncorrectLogin(String IncorrectEmail ,String IncorrectPassWord){
        email.sendKeys(IncorrectEmail);
        password.sendKeys(IncorrectPassWord);
        loginButton.click();
    }

    public void errorMessageIsDisplayed(String expectedColorxpectedErrorMessage, String expectedColor){
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getCssValue("color"),expectedColor);
        Assert.assertEquals(errorMessage.getText(),expectedColorxpectedErrorMessage);
    }
}
