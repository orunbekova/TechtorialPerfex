package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class NewProposalPage {
    public NewProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='subject']")
    WebElement subject;
    @FindBy(xpath = "//select[@name='rel_type']")
    WebElement relatedSelect;
    @FindBy(xpath = "//button[@data-id='rel_id']")
    WebElement customer;
    @FindBy(xpath = "//input[@aria-controls='bs-select-13']")
    WebElement customerSearchBar;
    @FindBy(xpath = "//*[@id='bs-select-13-0']/span[2]")
    WebElement customerSelected;
    @FindBy(xpath = "//button[@data-id='project_id']")
    WebElement project;
    @FindBy(xpath = "//div[@id='project_ajax_search_wrapper']/div/div/div[1]/input")
    WebElement projectSearchBar;

    @FindBy(xpath = "//span[contains(text(),'Apple Project')]")
    WebElement projectSelected;
    @FindBy(xpath ="//select[@name='item_select']")
    WebElement selectItem;
    @FindBy(xpath="//button[@class='btn pull-right btn-primary']")
    WebElement addButton;
    @FindBy(xpath ="//input[@name='quantity']")
    WebElement quantity;
    @FindBy(xpath="//td[@class='total']")
    WebElement total;
    @FindBy(xpath ="//button[contains(text(),'Save & Send')]")
    WebElement saveAndSend;

    public void addSubject(String subject) {
        this.subject.sendKeys(subject);
    }

    public void setRelatedSelect(String related) {
        BrowserUtils.selectBy(relatedSelect, related, "text");
    }

    public void selectCustomerAndProject(String customerName, String projectName) throws InterruptedException {
        customer.click();
        String str1 = customerName.split(" ")[0];
        Thread.sleep(1000);
        customerSearchBar.sendKeys(str1);
        Thread.sleep(2000);
        customerSelected.click();
        Thread.sleep(1000);
        project.click();
        Thread.sleep(2000);
        String str2 = projectName.split(" ")[2];
        projectSearchBar.sendKeys(str2);
        Thread.sleep(1000);
        projectSelected.click();
    }
    public void selectItems(WebDriver driver, String item1, String item2, String quant) throws InterruptedException {
        BrowserUtils.selectBy(selectItem,item1,"text");
        BrowserUtils.scrollWithJS(driver,addButton);
        Thread.sleep(2000);
        addButton.click();
        Thread.sleep(2000);
        BrowserUtils.selectBy(selectItem,item2,"text");
        Thread.sleep(1000);
        quantity.clear();
        quantity.sendKeys(quant);
        Thread.sleep(2000);
        addButton.click();

    }
    public void validateTotal(WebDriver driver,String total) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver,this.total);
        Thread.sleep(2000);
        Assert.assertEquals(total,BrowserUtils.getText(this.total));

    }
    public void clickSend(){
        saveAndSend.click();
    }
}
