package pages;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProposalsPage {
    public ProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='_buttons']//a[contains(@href,'proposals/proposal')]")
    WebElement newProposalButton;
    @FindBy(xpath = "//span[contains(@class,'inline-block s-status proposal')]")
    WebElement createdProposalStatus;
    @FindBy(xpath = "//*[@id=\"proposal\"]/div[1]/div/div[2]/div[2]/div[2]/button")
    WebElement moreButton;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement deleteButton;
    @FindBy(xpath = "//div[@class='input-group']//input[@type='search']")
    WebElement searchBox;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[1]/a")
    WebElement firstProposalId;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[2]/a")
    WebElement firstProposalSubject;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[3]")
    WebElement firstProposalCustomer;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[7]/a")
    WebElement firstProposalProject;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[10]/span")
    WebElement firstProposalStatus;
    @FindBy(xpath = "//a[@aria-controls='tab_comments']")
    WebElement comments;
    @FindBy(css = "#comment")
    WebElement commentBox;
    @FindBy(xpath = "//button[contains(text(),'Add Comment')]")
    WebElement addCommentButton;
    @FindBy(xpath = "//a[@aria-controls='tab_comments']//span[@class='badge total_comments']")
    WebElement commentsCount;
    @FindBy(xpath = "//button[contains(text(),'Convert')]")
    WebElement convertButton;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Invoice')]")
    WebElement invoiceButton;



    public void newProposalsButtonVisible() {
        Assert.assertTrue(newProposalButton.isDisplayed());
    }

    public void validateNewProposalButtonBackgroundColor(String color) {
        Assert.assertEquals(color, newProposalButton.getCssValue("background-color"));
    }
    public void clickNewProposal(){
        newProposalButton.click();
    }

    public void validateCreatedProposalStatus(String status){
        Assert.assertEquals(status, BrowserUtils.getText(createdProposalStatus));

    }
    public void deleteProposal(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        moreButton.click();
        Thread.sleep(500);
        deleteButton.click();
        Thread.sleep(500);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    public void searchProposal(String text){
        searchBox.sendKeys(text);

    }
    public void validateProposalCredentials(String subject,String projectName,String status) throws InterruptedException {
        Thread.sleep(1000);
       Assert.assertEquals(subject,BrowserUtils.getText(firstProposalSubject));
        Assert.assertEquals(projectName,BrowserUtils.getText(firstProposalProject));
        Assert.assertEquals(status,BrowserUtils.getText(firstProposalStatus));
    }
    public void clickProposalId(WebDriver driver) throws InterruptedException {
        BrowserUtils.clickWithJS(driver,firstProposalId);
        Thread.sleep(2000);
    }
    public void addCommentToProposal(String comment) throws InterruptedException {
       comments.click();
       Thread.sleep(1000);
       commentBox.sendKeys(comment);
       addCommentButton.click();
    }
    public void verifyCommentsNumber(String number){
        Assert.assertEquals(number,BrowserUtils.getText(commentsCount));
    }
    public void convertInvoice(){
        convertButton.click();
        invoiceButton.click();

    }
}