package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class DashboardPage {
    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Sales')]")
    WebElement salesModule;
    @FindBy(xpath = "//span[contains(text(),'Proposals')]")
    WebElement proposalsModule;
    @FindBy(xpath = "//li[@class='icon header-user-profile']//a[@data-toggle='dropdown']")
    WebElement profileIcon;
    @FindBy(xpath = "//ul[@class='dropdown-menu animated fadeIn']//li[@class='header-logout']//a[contains(text(),'Logout')]")
    WebElement logoutButton;


    public void salesClick(){
        salesModule.click();
    }
    public void proposalsClick(){
        proposalsModule.click();
    }

    public void logout(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);

        BrowserUtils.scrollWithJS(driver,profileIcon);
        Thread.sleep(1000);
         BrowserUtils.clickWithJS(driver,profileIcon);
        Thread.sleep(200);
        logoutButton.click();
        Thread.sleep(200);
    }

}
