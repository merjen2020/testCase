package com.amazon.step_definitions;


import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.CartPage;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class shopAmazon_StepDef {
    private AmazonHomePage amazonHomePage = new AmazonHomePage();
    private CartPage cartPage = new CartPage();


    @Given("I am on the main page of Amazon.com")
    public void i_am_on_the_main_page_of_Amazon_com() {
        Driver.get().get("https://www.amazon.com/");
        Driver.get().manage().window().maximize();
    }

    @When("I search for the book  {string}")
    public void iSearchForTheBook(String text) {
        amazonHomePage.searchFor(text);
    }

    @And("Click on the book from the search")
    public void clickOnTheBookFromTheSearch() {
        WebElement book =
                Driver.get().findElement
                        (By.xpath("//span[contains(text(),\"Ender's Game (Paperback)\")]"));
        book.click();
    }

    @And("I add the book to the card")
    public void iAddTheBookToTheCard() {
        amazonHomePage.addToCart();
    }

    @Then("Navigate to my cart and verify the book is there")
    public void navigate_to_my_cart_and_verify_the_book_is_there() {
        amazonHomePage.cartButton.click();
        Assert.assertTrue(amazonHomePage.getCartItemsInfo().contains("Ender's Game"),"The right book is not in the cart");

    }

    @Then("Delete the book from the cart and verify that it is no longer present")
    public void delete_the_book_from_the_cart_and_verify_that_it_is_no_longer_present() {
       cartPage.deleteFirstItem();
        cartPage.cartButton.click();
        String expectedMessage ="Your Amazon cart is empty";
        String actualMessage = Driver.get().findElement(By.xpath("//h2")).getText();
        actualMessage= actualMessage.trim();

        Assert.assertEquals(actualMessage,expectedMessage,"The cart is not empty");
    }



}


