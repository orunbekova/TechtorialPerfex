package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.IncorrectLoginPage;
import utils.DriverHelper;

public class IncorrectLoginSteps {

    WebDriver driver= DriverHelper.getDriver();
    IncorrectLoginPage incorrectLoginPage = new IncorrectLoginPage(driver);

    @Given("User navigate to Url {string}")
    public void user_navigate_to_url(String Url) {
  driver.get(Url);
    }

    @Given("User validates the title is {string} from LoginPage")
    public void user_validates_the_title_is_from_login_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
        System.out.println(driver.getTitle());

    }
    @Given("User validates the log_in is visible on the page")
    public void user_validates_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(incorrectLoginPage.isLoginVisible());
    }

    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String dashboardTitle) {
        Assert.assertEquals(dashboardTitle,driver.getTitle());
    }

    @When("User provides {string} and {string} to the loginPage")
    public void user_provides_and_to_the_login_page(String IncorrectEmail, String IncorrectPassWord) {

        incorrectLoginPage.IncorrectLogin(IncorrectEmail,IncorrectPassWord);

    }

    @Then("User validates {string} and {string} from loginPage")
    public void user_validates_and_from_login_page(String ExpectedErrorMessage, String ExpectedColor) {
incorrectLoginPage.errorMessageIsDisplayed(ExpectedErrorMessage,ExpectedColor);


    }

}
