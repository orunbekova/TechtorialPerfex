package pages.managerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ManagerMainPage {
    public ManagerMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//ul[@id='side-menu']/li/a")
    List<WebElement> sideMenu;
    @FindBy(xpath="//ul[@class='nav nav-second-level collapse in']/li/a")
    List<WebElement> salesSubMenu;

    public void clickSideMenuOption(String option){
        for(WebElement each: sideMenu){
            if(BrowserUtils.getText(each).equals(option)){
                each.click();
                break;
            }
        }
    }
    public void clickSalesSubMenu(String option) {
        for (WebElement each : salesSubMenu) {

            if (BrowserUtils.getText(each).equals(option)) {
                each.click();
                break;
            }
        }
    }
}
