package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_registering;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registeringStepDef {
    WebDriver driver = null;
    P01_registering register = new P01_registering(driver);

   @Given("user go to register page")
    public void go_to_regPage()
    {
        register.registerlink().click();
    }

    @When("user select gender type")
        public void select_gender()
    {
        register.maleGender().click();
    }

    @And("^user enter \"(.*)\" and \"(.*)\"$")
    public void username(String firstName, String lastName)
    {
        register.fillNames(firstName,lastName);
    }

    @And("user enter date of birth")
    public void birth_date()
    {
       register.birthDate();
    }

    @And("user enter email field")
    public void email_field()
    {
        register.email().sendKeys("test@test.com");
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void password_field(String first, String con)
    {
        register.fillPassword(first,con);
    }

    @And("user clicks on register button")
    public void register_button() throws InterruptedException {
        Thread.sleep(7000);
    register.regButton().click();
    }

    @Then("success message is displayed")
    public void success_message()
    {
        SoftAssert soft = new SoftAssert();
        String expectedmsg = "Your registration completed";
        String expectedcolor = "rgba(76, 177, 124, 1)";
        String actualResult1 = register.successMSG().getText();
        String actualResult2 = register.successMSG().getCssValue("color");
        Assert.assertTrue(actualResult1.contains(expectedmsg), "Success message");
        soft.assertTrue(actualResult2.contains(expectedcolor),"color Assertion");
        soft.assertAll();

    }

}
