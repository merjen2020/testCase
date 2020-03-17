package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "[value='Delete']")
    private WebElement deleteFirstItem;

    public void deleteFirstItem(){
        deleteFirstItem.click();
    }
}
