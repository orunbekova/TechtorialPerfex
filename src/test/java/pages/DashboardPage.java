package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Sales')]")
    WebElement salesModule;
    @FindBy(xpath = "//span[contains(text(),'Proposals')]")
    WebElement proposalsModule;


    public void salesClick(){
        salesModule.click();
    }
    public void proposalsClick(){
        proposalsModule.click();
    }

}
