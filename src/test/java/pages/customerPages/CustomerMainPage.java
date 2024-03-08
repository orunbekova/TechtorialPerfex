package pages.customerPages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class CustomerMainPage {
    public CustomerMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void validatePageTitle(WebDriver driver, String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li")
    List<WebElement> topNavigationMenu;

    public void clickTabFromNavigationMenu(String tabName) {
        for (WebElement tab : topNavigationMenu) {
            if (BrowserUtils.getText(tab).equals(tabName)) {
                tab.click();
                break;
            }
        }

    }
}