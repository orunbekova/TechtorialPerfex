package pages.managerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ManagerPaymentPage {
    public ManagerPaymentPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//label/div/input[@type='search']")
    WebElement searchBar;
    @FindBy(xpath = "//td[2]/a")
    List<WebElement> listInvoicesID;


    public void searchInvoice(String number){
        searchBar.sendKeys(number);
    }
    public  void searchAndClickInvoiceFromList(String invoiceID) {
        for (WebElement each : listInvoicesID) {
            if (BrowserUtils.getText(each).equals(invoiceID)) {
                each.click();
                break;
            }
        }

    }}