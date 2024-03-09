package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email")
    WebElement email;
    @FindBy(css = "#password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void userNavigatesToWebsite(String typeLogin, WebDriver driver) {
        switch (typeLogin) {

            case "employee":
                driver.get(ConfigReader.readProperty("employee_url"));
                break;
            case "customer":
                driver.get(ConfigReader.readProperty("customer_url"));
                break;
            case "manager":
                driver.get(ConfigReader.readProperty("manager_url"));
                break;

            default:
                System.out.println("Enter correct type of URL");
        }
    }

    public void login(String typeLogin) {
        switch (typeLogin) {
            case "employee":
                email.sendKeys(ConfigReader.readProperty("employee_username"));
                password.sendKeys(ConfigReader.readProperty("employee_password"));
                loginButton.click();
                break;
            case "customer":
                email.sendKeys(ConfigReader.readProperty("customer_username"));
                password.sendKeys(ConfigReader.readProperty("customer_password"));
                loginButton.click();
                break;
            case "manager":
                email.sendKeys(ConfigReader.readProperty("manager_username"));
                password.sendKeys(ConfigReader.readProperty("manager_password"));
                loginButton.click();
                break;

            default:
                System.out.println("Enter correct type of login");
        }


    }

    public boolean isLoginVisible() {

        return loginButton.isDisplayed();
    }


}
