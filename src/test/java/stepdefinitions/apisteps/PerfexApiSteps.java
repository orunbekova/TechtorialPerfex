package stepdefinitions.apisteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
public class PerfexApiSteps {
    Response response;

    @Given("I have base url {string} and endpoint {string}")
    public void i_have_base_url_and_endpoint(String baseURI, String endpoint) {

        RestAssured.baseURI=baseURI;
        RestAssured.basePath=endpoint;

    }
    @When("the user send the {string} request")
    public void the_user_send_the_request(String requestType) {

        switch (requestType){
            case "GET":
                response=given().header("authtoken", ConfigReader.readProperty("apiToken")).when().get();
                System.out.println(response.toString());
                break;
        }

    }
    @Then("verify status code {int}")
    public void verify_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("verify number of values {int}")
    public void verify_number_of_values(Integer count) {

        response.then().body("size()", is(count));

    }
    @Then("verify response {string} is {string}")
    public void verify_response_is(String jsonPath, String expectedValue) {
        String actualValue=response.jsonPath().getString(jsonPath);
        Assert.assertEquals(actualValue, expectedValue);
    }
    @Then("verify api response is ordered by {string}")
    public void verify_api_response_is_ordered_by(String keyName) {
        List<String> names=response.jsonPath().getList(keyName);

    }
    @Then("verify response {string} has size {string}")
    public void verify_response_has_size(String items, String expectedSize) {
        List<String> allItems= response.jsonPath().getList(items);
        String actualSize=String.valueOf(allItems.size());
        System.out.println(actualSize);
        Assert.assertEquals(actualSize,expectedSize);
    }
    @Then("verify proposal details")
    public void verify_response(DataTable dataTable) {
       Map<String,String> data = dataTable.asMap();
       for(Map.Entry<String,String> entry: data.entrySet())
           Assert.assertEquals(response.jsonPath().getString(entry.getKey()),entry.getValue());
    }




}

