package pages;

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

    @FindBy(linkText = "Invalid email or password")
    WebElement errorMessage;


    public void IncorrectLogin(String IncorrectEmail ,String IncorrectPassWord){
        email.sendKeys(IncorrectEmail);
        password.sendKeys(IncorrectPassWord);
        loginButton.click();
    }

    public void errorMessageIsDisplayed(String ExpectedErrorMessage, String ExpectedColor){
        errorMessage.isDisplayed();
    }
}
