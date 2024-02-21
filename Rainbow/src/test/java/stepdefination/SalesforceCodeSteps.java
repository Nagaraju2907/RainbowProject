package stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resuable.BaseCode;


public class SalesforceCodeSteps extends BaseCode {



@And("user clicks the login button")
    public void clickLogin(){

driver.findElement(By.id("Login")).click();

}

    @When("user enter the username {string} and password {string}")
    public void enterCredi(String userName, String password) {

        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    }

    @Then("user validate the error message")
    public void userValidateTheErrorMessage() {

        String actualErrorMessage =  driver.findElement(By.xpath("//form[@id='login_form']/child::div[@class='loginError']")).getText();

        System.out.println(actualErrorMessage);

        String expectedResult = "check your username and password. If you still can't log in, contact your Salesforce administrator.";

        if(actualErrorMessage.equals(expectedResult)){

            System.out.println("Equal");
        }
        else{
            System.out.println("not Equal");
        }

    }



    @Then("verify whether the user navigates to Homepage")
    public void verifyWhetherTheUserNavigatesToHomepage() {
    }
}
