package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverHelper {


    public static WebDriver driver;
    private DriverHelper(){}

    public static WebDriver getDriver(){

        if(driver==null || ((RemoteWebDriver)driver).getSessionId()==null){
            String browser="chrome";

            switch (browser){

                    break;
               case "chrome":
                   String hubURL = "http://54.88.171.18:4444";
                   ChromeOptions options = new ChromeOptions();
                   try {
                       driver = new RemoteWebDriver(new URL(hubURL),options);
                   } catch (MalformedURLException e) {
                       throw new RuntimeException(e);
                   }
                   break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                default:
                    driver=new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
}
