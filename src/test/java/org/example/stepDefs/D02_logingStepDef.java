package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_logging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D02_logingStepDef {

    WebDriver driver = null;
    P02_logging login = new P02_logging(driver);

  @Given("user go to login page")
  public void user_open_browser() throws InterruptedException {
        login.loginPage().click();
    }

    @When("^user login with \"(.*)\" and \"(.*)\"$")
    public void valid_data(String username, String password)
    {
        login.loginSteps(username,password);
    }

    @And("user press on login button")
    public void loginBTN()
    {
        login.loginB().click();
    }

    @Then("user login to the system successfully")
    public void success()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"]")).isDisplayed());
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void unsuccessful()
    {
        SoftAssert soft = new SoftAssert();
        String expectedmsg = "Login was unsuccessful";
        String expectedcolor = "rgba(228, 67, 75, 1)";
        String actualResult1 = login.unsuccessMSG().getText();
        String actualResult2 = login.unsuccessMSG().getCssValue("color");
        soft.assertTrue(actualResult1.contains(expectedmsg), "Success message");
        soft.assertTrue(actualResult2.contains(expectedcolor),"color Assertion");

        soft.assertAll();
    }


}
