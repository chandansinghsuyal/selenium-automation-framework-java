package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCartButton = By.id("add-to-cart-button-4"); // Example for a product with id=4
    private By addToWishlistButton = By.id("add-to-wishlist-button-4");
    private By successMessage = By.cssSelector("div.bar-notification.success");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void addToWishlist() {
        driver.findElement(addToWishlistButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
} 