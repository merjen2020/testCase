package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(name="submit.add-to-cart-ubb")
            private WebElement addToCart;
    @FindBy(id="nav-cart")
            public WebElement cartButton;
    @FindBy(id="activeCartViewForm")
            private WebElement cartItems;

    BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void addToCart(){
        addToCart.click();
    }

    public String getCartItemsInfo(){
        return cartItems.getText();
    }


}
