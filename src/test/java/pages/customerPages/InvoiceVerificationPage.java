package pages.customerPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InvoiceVerificationPage {

    public InvoiceVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Invoices')] ")
    WebElement invoiceButton;

    @FindBy(xpath = "//a[@class='invoice-number']")
    List<WebElement> listOfInvoices;

    @FindBy(xpath = "//span[contains(text(),'Unpaid')]")
    WebElement invoiceStatus;

//    @FindBy(xpath = "//a[contains(text(),'INV-000023')]")
//    WebElement invoiceNumber;

    public void clickInvoice() {
        invoiceButton.click();
    }

    public boolean isInvoiceReceived(String invoiceNumber) {
        for (WebElement invoice : listOfInvoices) {
            if (invoice.getText().equals(invoiceNumber)) {
                invoice.click();
                return true;
            }
        }
        return false;
    }

    public void getInvoiceStatus(String status, String color) {
        Assert.assertEquals(invoiceStatus.getCssValue("color"), color);
        Assert.assertEquals(invoiceStatus.getText(), status);

    }
}






