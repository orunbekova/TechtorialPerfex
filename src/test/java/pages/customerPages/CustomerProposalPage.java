package pages.customerPages;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CustomerProposalPage {
    public CustomerProposalPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "h4.proposal-html-number")
    WebElement proposalID;
    @FindBy(xpath= "//span/strong")
    List<WebElement> productList;
    @FindBy(id= "accept_action")
    WebElement acceptButton;
    @FindBy(xpath="//span[@class='label label-success tw-ml-4']")
    WebElement acceptedStatus;
    public String getProposalID(){
        //System.out.println(BrowserUtils.getText(proposalID));
        return BrowserUtils.getText(proposalID).split("\\s+")[1];
    }
    public void validatePageTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }
    public void validateproductList(String product1,String product2){
        List<String> expectedProductList = Arrays.asList(product1,product2);
        for(int i=0;i<productList.size();i++){
            Assert.assertEquals(BrowserUtils.getText(productList.get(i)),expectedProductList.get(i));
        }
    }
    public void validateAcceptButton() {
        Assert.assertTrue(acceptButton.isDisplayed());
    }
    public void clickAcceptButton(){
        acceptButton.click();

    }
    public void validateAcceptedTextAndColor(String expectedText, String expectedColor){
        Assert.assertEquals(BrowserUtils.getText(acceptedStatus), expectedText);
        Assert.assertEquals(acceptedStatus.getCssValue("background-color"),expectedColor);
    }

}
