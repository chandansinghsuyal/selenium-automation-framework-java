package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartQtyInput = By.cssSelector("input.qty-input");
    private By updateCartButton = By.name("updatecart");
    private By removeButton = By.name("removefromcart");
    private By emptyCartMessage = By.cssSelector("div.order-summary-content");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void updateQuantity(String qty) {
        driver.findElement(cartQtyInput).clear();
        driver.findElement(cartQtyInput).sendKeys(qty);
        driver.findElement(updateCartButton).click();
    }

    public void removeFromCart() {
        driver.findElement(removeButton).click();
        driver.findElement(updateCartButton).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessage).getText();
    }
} 