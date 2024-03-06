package pages.customerPages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

//import static utils.DriverHelper.driver;


public class CustomerSignaturePage {
    public CustomerSignaturePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//button[@class='btn btn-success']")
    WebElement signButton;
    @FindBy(xpath = "//p[@class='text-danger']")
    WebElement signDocumentAlert;
    @FindBy(tagName = "canvas")
    WebElement canvas;
    public void clickSign(){
        signButton.click();
    }
    public void validateSignDocumentAlert(String expectedAlert,String expectedColor){
        Assert.assertEquals(BrowserUtils.getText(signDocumentAlert),expectedAlert);
        Assert.assertEquals(signDocumentAlert.getCssValue("color"),expectedColor);
    }

    //OPTION1 not working though
    public void canvasDraw(WebDriver driver) {
        // Get the size of the canvas
        //Dimension size = canvas.getSize();
        //// Create an instance of Actions class
        Actions draw = new Actions(driver);


        // Perform mouse click and drag to draw a line
        draw.moveToElement(canvas,10,20)
                .clickAndHold()
                .moveToElement(canvas,20,40)
                .release()
                .perform();

    }

    //OPTION 2
    public  void canvasDraw2(WebDriver driver) {
        // Execute JavaScript to draw on the canvas element
        String script = "var canvas = arguments[0];" +
                "var context = canvas.getContext('2d');" +
                "context.beginPath();" +
                "context.moveTo(50, 50);" +
                "context.bezierCurveTo(100,25,100,75,50,100);"+

                "context.stroke();";

        ((JavascriptExecutor) driver).executeScript(script, canvas);
    }

}
