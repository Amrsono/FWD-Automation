package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_home;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class D05_hoverCtgStepDef {

    WebDriver driver = null;
    P03_home home = new P03_home(driver);
    int random;
    String subCategory;

    @When("user hover category and select subcategory then check if the name equals to page title")
    public void userHoverCategoryAndSelectSubcategThenCheckIfTheNameEqualsToPageTitle()
    {
        int randomNumber = new Random().nextInt(3);

        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(home.categories().get(randomNumber)).perform();
        String mainCategory = home.categories().get(randomNumber).getText();
        System.out.println(randomNumber);
        System.out.println(mainCategory);
        this.random = randomNumber + 1;

    }
    @And("user go to subcategory page")
    public void subPage()
    {
        home.subCategories(random);

        int randomNumberSub = new Random().nextInt(3);

        this.subCategory = home.subCategories(random).get(randomNumberSub).getText();
        System.out.println(subCategory);
        home.subCategories(random).get(randomNumberSub).click();

    }

    @Then("user check if page title equals subcategory name")
    public void checkTitle()
    {
        String actualResult = home.pageTitle().getText();
        Assert.assertTrue(actualResult.contains(subCategory));

    }
}

