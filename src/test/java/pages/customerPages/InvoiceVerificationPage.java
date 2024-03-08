package pages.customerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceVerificationPage {
    public InvoiceVerificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
  @FindBy(xpath = "//a[contains(text(),'Invoices')] ")
    WebElement invoiceButton;


}
