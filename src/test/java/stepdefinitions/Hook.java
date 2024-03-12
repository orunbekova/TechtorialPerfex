package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {
    public WebDriver driver;
//    @Before//it must be imported from io cucumber not junit
//    public void setup() {
//        driver= DriverHelper.getDriver();
//        driver.get(ConfigReader.readProperty("test_url"));
//    }
    @After
    public void tearDown(){
//     BrowserUtils.getScreenShotWithCucumber(driver,scenario);
     driver= DriverHelper.getDriver();
     //driver.quit();
    }
}
