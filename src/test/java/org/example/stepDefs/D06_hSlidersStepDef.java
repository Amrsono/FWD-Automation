package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_home;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class D06_hSlidersStepDef {
    WebDriver driver = null;
    P03_home home = new P03_home(driver);
    
    
    @When("clicking on the first slider")
    public void firstSlider() throws InterruptedException {

        home.slidewaiter(home.firstSliderHref());
        home.firstSliderHref().click();

    }

    @Then("check if u are rotated to nokia page")
    public void checkIfUAreRotatedToNokiaPage()
    {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");
    }

    @When("clicking on the second slider")
    public void clickingOnTheSecondSlider() {
                home.slidewaiter(home.secondSliderHref());
                home.secondSliderHref().click();
        
    }



    @Then("check if u are rotated to iphone page")
    public void checkIfUAreRotatedToIphonePage()
    {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), " https://demo.nopcommerce.com/iphone-6");
    }
}
