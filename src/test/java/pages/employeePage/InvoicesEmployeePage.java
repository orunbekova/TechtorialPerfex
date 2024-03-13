package pages.employeePage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class InvoicesEmployeePage {
    public InvoicesEmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label/div/input[@type='search']")
    WebElement searchBar;
    @FindBy(xpath = "//td[@class='sorting_2']/a")
    List<WebElement> listInvoicesID;

    @FindBy(xpath = "//div[@class='pull-right']")
    List<WebElement> rightButtons;

    public void searchInvoiceNo(String number) {
        searchBar.sendKeys(number);
    }

    public void searchAndClickInvoiceFromList(String invoiceID) {
        for (WebElement each : listInvoicesID) {
            if (BrowserUtils.getText(each).equals(invoiceID)) {
                each.click();
                break;
            }
        }
    }

    public void verifyPaymentButtonisNotVisible(String buttonName){
        for(WebElement button:rightButtons){
            Assert.assertNotEquals(BrowserUtils.getText(button), buttonName);
        }
    }
}
