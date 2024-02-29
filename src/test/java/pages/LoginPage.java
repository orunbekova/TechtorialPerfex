package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public LoginPage(WebDriver driver){
    PageFactory.initElements(driver,this);
}

    @FindBy(css = "#email")
    WebElement email;
    @FindBy(css = "#password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;


    public void login(String username,String password){
       email.sendKeys(username);
       this.password.sendKeys(password);
       loginButton.click();

    }

    public boolean isLoginVisible(){

        return loginButton.isDisplayed();
    }
}
