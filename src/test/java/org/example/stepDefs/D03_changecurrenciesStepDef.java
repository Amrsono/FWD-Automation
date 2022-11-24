package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_changecurrenciesStepDef
{
    WebDriver driver = null;
    P03_home home = new P03_home(driver);
    @When("user select euro option")
    public void select_euro()
    {

        Select select = new Select(home.currency_list());
        select.selectByVisibleText("Euro");
    }


    @Then("euro symbol is displayed on all products")
    public void euroSymbolIsDisplayedOnAllProducts()
    {
        for(int x=0 ; x < 4 ; x++)
        {

      String value = home.priceCurrency().get(x).getText();
            System.out.println(value);
         String[] expectedResult = {"€1032.00","€1548.00","€210.70","€21.50"};
            Assert.assertTrue(value.contains(expectedResult[x]));
        }


    }
}
