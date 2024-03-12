package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.Locale;

public class InvoicePage {
    public InvoicePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='clientid']")
    WebElement customerBox;
    @FindBy(xpath = "//button[@class='btn btn-primary invoice-form-submit transaction-submit']")
    WebElement saveButton;
    @FindBy(xpath = "//span[@class='label label-danger  s-status invoice-status-1']")
    WebElement invoiceStatus;
    @FindBy(xpath = "//h4//span[contains(text(),'INV-')]")
            WebElement recordHeader;
    @FindBy(css = "#invoice-number")
            WebElement invoiceNumber;
    @FindBy(xpath = "//div[@class='btn-group dropup']//button[.='Save']")
            WebElement saveInvoiceButton;
    @FindBy(xpath = "//div[@class='btn-group']//button[contains(text(),'More')]")
            WebElement moreButton;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Delete')]")
            WebElement deleteButton;

    String invoiceNumRecorded;

    public void verifyCustomerDefaultOption(String customer){
        Select select = new Select(customerBox);
        Assert.assertEquals(customer,BrowserUtils.getText(select.getFirstSelectedOption()));
    }
    public void saveInvoice(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        BrowserUtils.scrollWithJS(driver,saveButton);
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(1000);
    }
    public void verifyInvoiceStatus(String status){
        Assert.assertEquals(status,BrowserUtils.getText(invoiceStatus));
    }

    public void verifyInvoiceNumber() throws InterruptedException {
        invoiceNumRecorded=BrowserUtils.getText(recordHeader);
        saveInvoiceButton.click();Thread.sleep(1000);
        Assert.assertEquals(invoiceNumRecorded,BrowserUtils.getText(invoiceNumber));
    }
    public void deleteInvoice(WebDriver driver) throws InterruptedException {
        moreButton.click();
        Thread.sleep(1000);
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);

    }



}
