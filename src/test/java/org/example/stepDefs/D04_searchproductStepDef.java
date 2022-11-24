package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchproductStepDef {
    WebDriver driver = null;
    P03_home home = new P03_home(driver);

    @When("user clicks on search field")
    public void click_search()
    {
        WebElement search = Hooks.driver.findElement(By.id("small-searchterms"));
        search.click();
    }

    @And("user search with {string}")
    public void userSearchWith(String arg0) throws InterruptedException {

        home.search().sendKeys(arg0);
        home.search().submit();
        Thread.sleep(2000);
    }

    @Then("user could find {string} relative results")
    public void userFindRelativeResults(String arg0)
    {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/search?q="+arg0);
        soft.assertAll();
    }

    @Then("user could find {string} inside product detail page")
    public void userFindInsideProductDetailPage(String arg0) throws InterruptedException {

        home.title().click();

        System.out.println(home.sku().getText());
        Assert.assertTrue(arg0.contains(home.sku().getText()));
    }
}
