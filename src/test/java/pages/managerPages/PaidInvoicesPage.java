package pages.managerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaidInvoicesPage {
    public PaidInvoicesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-title='Filter by']")
    WebElement filterButton;

    @FindBy(xpath = "//a[text()='Paid']")
    WebElement paidButton;
    @FindBy(xpath = "//span[contains(text(),'Paid')]")
    List<WebElement> listOfPaidInvoices;
    @FindBy(css = "#DataTables_Table_0_info")
    WebElement entriesTotal;
    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    WebElement dashboardModule;

    @FindBy(xpath = "//*[@id=\"widget-finance_overview\"]/div/div/div/div[2]/div[1]/div/div[12]/a/span")
    WebElement  invoiceOverviewPaid;

    public void clickFilterButton() {
        filterButton.click();
    }

    public void clickPaidButton() throws InterruptedException {
        paidButton.click();
        Thread.sleep(1000);
    }

//    public String getTotalNumOfPaidInvoicesFromBottom(String totalEntitiesDisplayed) {
//        String infoText = entriesTotal.getText();
//        String[] parts = infoText.split(" ");
//        String numberString = parts[parts.length - 2];
//         totalEntitiesDisplayed = numberString;
//
//        return totalEntitiesDisplayed;
//    }



    public int getTotalNumOfPaidInvoices() {
        return listOfPaidInvoices.size();
    }
    public String verifyPaidInvoiceCount(String expectedCount){
        String  total=entriesTotal.getText().substring(12,15);
        System.out.println(expectedCount);
        System.out.println(total);
        if(total.equals(expectedCount)){
            return total;
        }   return null;
    }
    public void dashboardClick(){
        dashboardModule.click();
    }
    public int getTotalNumOfPaidInvoicesOverview(){
        String text=invoiceOverviewPaid.getText();
        int numPaidDisplayed=Integer.parseInt(text);
        return numPaidDisplayed;
    }
}


