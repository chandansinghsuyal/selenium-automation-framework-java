package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {
    private By wishlistTable = By.cssSelector("table.wishlist-content");
    private By removeButton = By.name("removefromcart");
    private By updateWishlistButton = By.name("updatecart");
    private By emptyWishlistMessage = By.cssSelector("div.wishlist-content");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWishlistDisplayed() {
        return driver.findElement(wishlistTable).isDisplayed();
    }

    public void removeFromWishlist() {
        driver.findElement(removeButton).click();
        driver.findElement(updateWishlistButton).click();
    }

    public String getEmptyWishlistMessage() {
        return driver.findElement(emptyWishlistMessage).getText();
    }
} 