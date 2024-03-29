package pages.managerPages;


import org.apache.commons.exec.DaemonExecutor;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

import static utils.DriverHelper.driver;

public class ExpensesPage {
    public ExpensesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    Actions actions= new Actions(driver);
    @FindBy(linkText = "Record Expense")
    WebElement recordExpenseButton;
    @FindBy(id = "expense_name")
    WebElement expenseName;
    @FindBy(xpath = "//textarea[@id='note']")
    WebElement expenseNote;
    @FindBy(xpath = "//select[@id='category']")
    WebElement expenseCategory;
    @FindBy(xpath = "//input[@id='amount']")
    WebElement amount;
    @FindBy(xpath = "//button[@data-id='clientid']")
    WebElement customer;
    @FindBy(xpath = "//input[@aria-controls='bs-select-9']")
    WebElement customerSearchBar;
    @FindBy(xpath = "//a[@id='bs-select-9-0']")
    WebElement customerSelected;
    @FindBy(xpath = "//button[@data-id='project_id']")
    WebElement project;
    @FindBy(xpath = "//div[@id='project_ajax_search_wrapper']/div/div/div[1]/input")
    WebElement projectSearchBar;

    @FindBy(xpath = "//span[contains(text(),'Apple Project')]")
    WebElement projectSelected;

    @FindBy(xpath = "//select[@id='paymentmode']")
    WebElement paymentMode;
    @FindBy(xpath = "//form[@id='expense-form']/div[1]/div/div/div[11]/button")
    WebElement save;
    @FindBy(xpath = "//p[@class='text-muted mbot15']")
    WebElement noteReceipt;
    @FindBy(xpath = "//h4[@id='expenserCreator']/a")
    WebElement creatorName;
    @FindBy(xpath = "//li[@class='icon header-user-profile']")
    WebElement accountIcon;
    @FindBy(xpath = "//td[@class='sorting_1']")
    WebElement categoryItem;
    @FindBy(xpath = "//div[@class='row-options']")
    WebElement rowOptions;
    @FindBy(xpath = "//div[@class='row-options']//a[1]")
    WebElement viewOption;
    public  void clickViewOption(){
        viewOption.click();
    }
    @FindBy(xpath = "//*[@id=\"expense\"]/div/div")
    WebElement detailPanel;
    @FindBy(xpath = "//i[@class='fa fa-angle-double-right']")
    WebElement rightToggle;
    @FindBy(xpath = "//i[@class='fa fa-angle-double-left']")
    WebElement leftToggle;
    public void verifyLefttoggleOpenNewPanel(){
        leftToggle.click();
        Assert.assertTrue(detailPanel.isDisplayed());
    }
    public void verifyAfterToggleNewPanelHide(){
        rightToggle.click();
        Assert.assertFalse(detailPanel.isDisplayed());
    }
    public void verifyNewPanelIsDisplayed(){
        Assert.assertTrue(detailPanel.isDisplayed());
    }
    public void hoverOverCategoryItem() throws InterruptedException {
       actions.moveToElement(categoryItem).perform();
       Thread.sleep(800);
    }
    public void verifyRowOptions(String rowOption){
        Assert.assertEquals(BrowserUtils.getText(rowOptions), rowOption);
    }

    public void validatePageTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public void clickRecordExpense() {
        recordExpenseButton.click();
    }

    public void recordExpense(WebDriver driver, String nameExpense, String noteExpense, String category,
                              String value, String customerName, String projectName, String paymentMode) throws InterruptedException {
        expenseName.sendKeys(nameExpense);
        expenseNote.sendKeys(noteExpense);
        BrowserUtils.selectBy(expenseCategory, category, "text");
        amount.sendKeys(value);
        Thread.sleep(1000);
        customer.click();
        customerSearchBar.sendKeys(customerName);
        customerSelected.click();
        Thread.sleep(1000);
        BrowserUtils.scrollWithJS(driver, project);
        project.click();
        Thread.sleep(2000);
        String str = projectName.split(" ")[2];
        projectSearchBar.sendKeys(str);
        Thread.sleep(1000);
        projectSelected.click();
        BrowserUtils.selectBy(this.paymentMode, paymentMode, "text");
    }

    public void save() {
        save.click();
    }

    public void validateReceiptNote(String expectedNote) {
        Assert.assertEquals(BrowserUtils.getText(noteReceipt), expectedNote);
    }

    public void validateCreatorname(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountIcon).perform();
        Assert.assertEquals(accountIcon.getAttribute("data-original-title"), BrowserUtils.getText(creatorName));
    }


}
