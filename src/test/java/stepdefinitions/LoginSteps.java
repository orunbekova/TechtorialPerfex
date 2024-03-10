package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {

    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Given("User navigates to {string} login page")
    public void user_navigates_to_login_page(String typeLogin) {
       loginPage.userNavigatesToWebsite(typeLogin,driver);
    }

    @Given("User validates the title is {string} from LoginPage")
    public void user_validates_the_title_is_from_login_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());

    }
    @Given("User validates the log_in is visible on the page")
    public void user_validates_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(loginPage.isLoginVisible());
    }
       @When("User provides {string} login and password to the loginPage")
    public void user_provides_login_and_password_to_the_login_page(String typeLogin) {
      loginPage.login(typeLogin);
    }
    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String dashboardTitle) {
        Assert.assertEquals(dashboardTitle,driver.getTitle());
    }


    }


