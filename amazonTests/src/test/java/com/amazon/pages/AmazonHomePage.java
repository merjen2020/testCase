package com.amazon.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage {

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchbox;

    public void searchFor(String item){
        searchbox.sendKeys(item, Keys.ENTER);
    }
}
