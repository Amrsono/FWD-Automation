package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_home;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    WebDriver driver = null;
    P03_home home = new P03_home(driver);


    @When("put a product to wishlist")
    public void wishlistItem() throws InterruptedException {
        home.wishlist().click();
        Thread.sleep(2000);
    }


    @And("check the success message")
    public void checkSuccessMessage()
    {
        SoftAssert soft = new SoftAssert();
        String expectedResult = "The product has been added to your ";
        String expectedcolor = "rgba(119, 119, 119, 1)";

        String actualResult = home.wishlistMSG().getText();
        String actualColor = home.wishlist().getCssValue("color");
        System.out.println(actualColor);
        soft.assertTrue(actualColor.contains(expectedcolor));
        soft.assertTrue(actualResult.contains(expectedResult));
        soft.assertAll();
    }

    @And("user go to wishlist page")
    public void userGoToWishPage() throws InterruptedException {
        Thread.sleep(5000);
        home.wishlistPage().click();
    }

    @Then("check the product quantity")
    public void chkProdQuantity() {
        SoftAssert soft = new SoftAssert();
        String expectedQty = "1";
        String actualQty = home.expectedQty().getAttribute("value");
        soft.assertTrue(actualQty.contains(expectedQty));
    }


}
