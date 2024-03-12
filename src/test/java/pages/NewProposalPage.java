package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.util.List;

public class NewProposalPage {

    public NewProposalPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#subject")
    WebElement subjectBox;
    @FindBy(xpath = "//select[@id='rel_type']")
    WebElement relatedDropBox;
    @FindBy(xpath = "//div[@class='filter-option-inner']//div[.='Select and begin typing']")
    WebElement customerBox;
    @FindBy(xpath = "//div[@class='bs-searchbox']//input[@aria-controls='bs-select-13']")
    WebElement customerSearchBox;
    @FindBy(xpath = "//a[@id='bs-select-13-0']")
    WebElement customerSearchResult;


    @FindBy(xpath = "//div[@class='filter-option-inner']//div[.='Select and begin typing']")
    WebElement projectBox;
    @FindBy(xpath = "//div[@class='dropdown bootstrap-select projects ajax-search bs3 open']//input[@type='search']")
    WebElement projectSearchBox;
    @FindBy(xpath = "//div[@class='dropdown bootstrap-select projects ajax-search bs3 open']//a[contains(@id,'bs-select')]")
    WebElement projectSearchResult;
    @FindBy(xpath = "//div[@class='filter-option-inner']//div[.='Add Item']")
    WebElement addItem;
    @FindBy(xpath = "//li[@class='optgroup-1']//a[@role='option']//span[@class='text']")
    List<WebElement> listOfItems;
    @FindBy(xpath = "//input[@placeholder='Quantity']")
    WebElement quantityBox;
    @FindBy(xpath = "//button[contains(@onclick,'add_item_to_table')]")
    WebElement addItemToTable;
    @FindBy(xpath = "//td[@class='total']")
    WebElement total;
    @FindBy(xpath = "//button[contains(text(),'Save & Send')]")
    WebElement saveSendButton;



    public void setSubject(String subject){
        subjectBox.sendKeys(subject);
    }

    public void createNewProposal (String related, String search, String client, String project) throws InterruptedException {
        BrowserUtils.selectBy(relatedDropBox,related,"text");
        Thread.sleep(1000);
        customerBox.click();
        Thread.sleep(1000);
        customerSearchBox.sendKeys(search);
        Thread.sleep(1000);
        Assert.assertEquals(client,BrowserUtils.getText(customerSearchResult));
        customerSearchResult.click();
        Thread.sleep(1000);
        projectBox.click();
        Thread.sleep(1000);
        projectSearchBox.sendKeys(search);
        Thread.sleep(2000);
        Assert.assertEquals(project,BrowserUtils.getText(projectSearchResult));
        projectSearchResult.click();
        Thread.sleep(1000);

    }
    public void addItem(String itemName, String quantity) throws InterruptedException {
        WebDriver driver = DriverHelper.getDriver();
        BrowserUtils.scrollWithJS(driver,addItem);
              addItem.click();
        Thread.sleep(1000);
        for (WebElement item:listOfItems){
            if(BrowserUtils.getText(item).contains(itemName))
            { item.click();
            break;}

        }
        Thread.sleep(1000);
        quantityBox.clear();
        quantityBox.sendKeys(quantity);
        Thread.sleep(1000);
        addItemToTable.click();
        Thread.sleep(1000);

    }
    public void validateTotalPrice(String total){
        WebDriver driver = DriverHelper.getDriver();
        BrowserUtils.scrollWithJS(driver,this.total);
        Assert.assertEquals(total,BrowserUtils.getText(this.total));
    }
    public void clickSaveSend() throws InterruptedException {

        saveSendButton.click();
        Thread.sleep(1000);
    }



}
