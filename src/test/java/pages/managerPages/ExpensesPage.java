package pages.managerPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ExpensesPage {
    public ExpensesPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Record Expense")
    WebElement recordExpenseButton;
    @FindBy(id = "expense_name")
    WebElement expenseName;
    @FindBy(xpath="//textarea[@id='note']")
    WebElement expenseNote;
    @FindBy(xpath="//select[@id='category']")
    WebElement expenseCategory;
    @FindBy(xpath="//input[@id='amount']")
    WebElement amount;

    public void validatePageTitle(WebDriver driver, String expectedTitle){
       Assert.assertEquals( driver.getTitle(),expectedTitle);
    }
    public void clickRecordExpense(){
        recordExpenseButton.click();
    }
    public void recordExpense(String nameExpense,String noteExpense, String category, String value){
        expenseName.sendKeys(nameExpense);
        expenseNote.sendKeys(noteExpense);
        BrowserUtils.selectBy(expenseCategory,category,"text");
        amount.sendKeys(value);




    }

}
