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

    @When("User provides {string} and {string} to the loginPage")
    public void user_provides_and_to_the_login_page(String IncorrectEmail, String IncorrectPassWord) {

        incorrectLoginPage.IncorrectLogin(IncorrectEmail,IncorrectPassWord);

    }

    @Then("User validates {string} and {string} from loginPage")
    public void user_validates_and_from_login_page(String ExpectedErrorMessage, String ExpectedColor) {
        incorrectLoginPage.errorMessageIsDisplayed(ExpectedErrorMessage,ExpectedColor);


    }

}
