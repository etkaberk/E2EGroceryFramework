package stepDefinitions;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Products;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {
RequestSpecification baseReq;
Response response;
    @Given(": Category {string} {string}")
    public void category(String categoryName, String results) {
        RestAssured.baseURI ="https://simple-grocery-store-api.glitch.me";
        baseReq = new RequestSpecBuilder().setBaseUri("https://simple-grocery-store-api.glitch.me")
                .addQueryParam("category", categoryName)
                .addQueryParam("results",results)
                .setContentType(ContentType.JSON).build();

    }
    @When(": user calls GET API")
    public void user_calls_get_api() {
       response = given().spec(baseReq).when().get("/products");
    }
    @Then(":check if the status code is {int}")
    public void check_if_the_status_code_is(Integer statusCode) {
        Response responsee = response.then().extract().response();
       assertEquals( responsee.getStatusCode(), 200);




    }

  //  @And(": get first product's id")
    //public void getFirstProductsId() {
   // }
}
